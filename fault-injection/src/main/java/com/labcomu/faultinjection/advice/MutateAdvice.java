package com.labcomu.faultinjection.advice;

import com.labcomu.faultinjection.annotation.Mutate;
import com.labcomu.faultinjection.api.Mutator;
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
public class MutateAdvice {
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Around("@annotation(com.labcomu.faultinjection.annotation.Mutate)")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();

        log.debug("'{}.{}' intercepted", signature.getDeclaringTypeName(), signature.getName());

        Mutate mutate = signature.getMethod().getAnnotation(Mutate.class);

        Class<? extends Mutator> clazz = mutate.value();

        Object value = point.proceed();

        Mutator mutator = clazz.getDeclaredConstructor().newInstance();

        mutator.mutate(value);

        return value;
    }
}