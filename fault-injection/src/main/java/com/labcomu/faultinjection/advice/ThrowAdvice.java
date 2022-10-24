package com.labcomu.faultinjection.advice;

import com.labcomu.faultinjection.annotation.Throw;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Aspect
@Component
@ConditionalOnExpression("${aspect.enabled:true}")
@Slf4j
public class ThrowAdvice {
    @Around("@annotation(com.labcomu.faultinjection.annotation.Throw)")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();

        log.debug("'{}.{}' intercepted", signature.getDeclaringTypeName(), signature.getName());

        Throw twrowAnnotation = signature.getMethod().getAnnotation(Throw.class);

        Class<? extends Exception> exceptionClass = twrowAnnotation.exception();

        throw exceptionClass.getDeclaredConstructor().newInstance();
    }
}