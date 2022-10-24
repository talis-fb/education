package com.labcomu.faultinjection.advice;

import com.labcomu.faultinjection.annotation.internal.Handles;
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
public class HandlesAdvice {
    private final HandleAdvice advice;

    public HandlesAdvice(HandleAdvice advice) {
        this.advice = advice;
    }

    @Around("@annotation(com.labcomu.faultinjection.annotation.internal.Handles)")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
        Handles handles = AdviceUtil.init(Handles.class, log, point);

        Object value = point.proceed();

        Stream.of(handles.value()).forEach(handle -> advice.doHandle(handle, value));

        return value;
    }
}