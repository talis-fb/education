package com.labcomu.faultinjection.advice;

import com.labcomu.faultinjection.annotation.Delay;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Aspect
@Component
@ConditionalOnExpression("${aspect.enabled:true}")
@Slf4j
public class DelayAdvice extends Advice<Delay> {
    @Around("@annotation(com.labcomu.faultinjection.annotation.Delay)")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
        return super.advice(Delay.class, log, point);
    }

    protected double threshold(Delay delay) {
        return delay.threshold();
    }

    protected Object apply(Delay delay, ProceedingJoinPoint point) throws Throwable {
        Duration duration = Duration.of(delay.value(), delay.unit());

        Thread.sleep(duration.toMillis());

        return point.proceed();
    }
}