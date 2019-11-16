package com.gurkan.dms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    LoggingHandlerMethodInterceptor loggingHandlerMethodInterceptor ;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loggingHandlerMethodInterceptor).addPathPatterns("/**");
    }
}