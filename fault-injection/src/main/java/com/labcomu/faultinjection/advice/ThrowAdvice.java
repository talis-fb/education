package com.labcomu.faultinjection.advice;

import com.labcomu.faultinjection.annotation.Throw;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Aspect
@Component
@ConditionalOnExpression("${aspect.enabled:true}")
@Slf4j
public class ThrowAdvice extends Advice<Throw> {

    @Around("@annotation(com.labcomu.faultinjection.annotation.Throw)")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
        return super.advice(Throw.class, log, point);
    }

    protected double threshold(Throw throw_) {
        return throw_.threshold();
    }

    protected Object apply(Throw throw_, ProceedingJoinPoint point) throws Throwable {
        Class<? extends Exception> exceptionClass = throw_.exception();

        throw exceptionClass.getDeclaredConstructor().newInstance();
    }
}