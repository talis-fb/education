package com.labcomu.faultinjection.advice;

import com.labcomu.faultinjection.annotation.internal.Handles;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Aspect
@Component
@ConditionalOnExpression("${aspect.enabled:true}")
@Slf4j
public class HandlesAdvice extends Advice<Handles> {
    private final HandleAdvice advice;

    public HandlesAdvice(HandleAdvice advice) {
        this.advice = advice;
    }

    @Around("@annotation(com.labcomu.faultinjection.annotation.internal.Handles)")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
        return super.advice(Handles.class, log, point);
    }

    protected double threshold(Handles handles) {
        return handles.threshold();
    }

    protected Object apply(Handles handles, ProceedingJoinPoint point) throws Throwable {
        Object value = point.proceed();

        Stream.of(handles.value()).forEach(handle -> advice.doApply(handle, value));

        return value;
    }
}