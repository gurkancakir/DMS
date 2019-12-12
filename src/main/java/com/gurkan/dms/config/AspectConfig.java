package com.gurkan.dms.config;

import com.gurkan.dms.bean.Document;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Slf4j
public class AspectConfig {

    @Before("execution(* com.gurkan.dms.service.DocumentService.add(..))")
    public void before (JoinPoint joinPoint) {
        Document document = (Document) joinPoint.getArgs()[0];
        log.info("aspect::before : " + document.getContent());
    }

    @After("execution(* com.gurkan.dms.service.DocumentService.add(..))")
    public void after (JoinPoint joinPoint) {
        Document document = (Document) joinPoint.getArgs()[0];
        log.info("aspect::after : " + document.getContent());
    }

    @AfterReturning("execution(* com.gurkan.dms.service.DocumentService.add(..))")
    public void afterReturn (JoinPoint joinPoint) {
        Document document = (Document) joinPoint.getArgs()[0];
        log.info("aspect::afterReturn : " + document.getContent());
    }

    @AfterThrowing("execution(* com.gurkan.dms.service.DocumentService.add(..))")
    public void afterThrow (JoinPoint joinPoint) {
        Document document = (Document) joinPoint.getArgs()[0];
        log.info("aspect::afterThrow : " + document.getContent());
    }
}
