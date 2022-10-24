package com.labcomu.faultinjection.advice;

import com.labcomu.faultinjection.annotation.internal.Mutates;
import com.labcomu.faultinjection.util.AdviceUtil;
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
public class MutatesAdvice {
    private final MutateAdvice advice;

    public MutatesAdvice(MutateAdvice advice) {
        this.advice = advice;
    }

    @Around("@annotation(com.labcomu.faultinjection.annotation.internal.Mutates)")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
        Mutates mutates = AdviceUtil.init(Mutates.class, log, point);

        Object value = point.proceed();

        Stream.of(mutates.value()).forEach(mutate -> advice.doMutate(mutate, value));

        return value;
    }
}