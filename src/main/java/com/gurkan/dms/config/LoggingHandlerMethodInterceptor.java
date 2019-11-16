package com.gurkan.dms.config;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.MethodParameter;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoggingHandlerMethodInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = LoggerFactory.getLogger(LoggingHandlerMethodInterceptor.class);

    private final ParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (handler instanceof HandlerMethod) {
            logger.info(getControllerNameAndMethodName((HandlerMethod) handler));
        }

        return true;
    }

    private String getControllerNameAndMethodName(HandlerMethod handlerMethod) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nController:\n").append(handlerMethod.getBeanType().getSimpleName());
        sb.append("\nMethod:\n");
        sb.append(handlerMethod.getMethod().getReturnType().getSimpleName()).append(" ");
        sb.append(handlerMethod.getMethod().getName()).append("(");
        for (MethodParameter param : handlerMethod.getMethodParameters()) {
            param.initParameterNameDiscovery(this.parameterNameDiscoverer);
            for (Annotation annotation : param.getParameterAnnotations()) {
                sb.append(annotation).append(" ");
            }
            sb.append(param.getParameterType().getSimpleName()).append(" ");
            sb.append(param.getParameterName());
            if (param.getParameterIndex() < handlerMethod.getMethodParameters().length - 1) {
                sb.append(" ");
            }
        }
        sb.append(")\n");
        return sb.toString();
    }

}