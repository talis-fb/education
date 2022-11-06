package com.labcomu.faultinjection.advice;

import com.labcomu.faultinjection.annotation.internal.Mutates;
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
public class MutatesAdvice extends Advice<Mutates> {
    private final MutateAdvice advice;

    public MutatesAdvice(MutateAdvice advice) {
        this.advice = advice;
    }

    @Around("@annotation(com.labcomu.faultinjection.annotation.internal.Mutates)")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
        return super.advice(Mutates.class, log, point);
    }

    protected double threshold(Mutates mutates) {
        return mutates.threshold();
    }

    protected Object apply(Mutates mutates, ProceedingJoinPoint point) throws Throwable {
        Object value = point.proceed();

        Stream.of(mutates.value()).forEach(mutate -> advice.doApply(mutate, value));

        return value;
    }
}