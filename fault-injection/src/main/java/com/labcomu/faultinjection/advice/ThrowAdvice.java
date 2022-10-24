package com.labcomu.faultinjection.advice;

import com.labcomu.faultinjection.annotation.Throw;
import com.labcomu.faultinjection.util.AdviceUtil;
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
public class ThrowAdvice {
    @Around("@annotation(com.labcomu.faultinjection.annotation.Throw)")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
        Throw throw_ = AdviceUtil.init(Throw.class, log, point);

        Class<? extends Exception> exceptionClass = throw_.exception();

        throw exceptionClass.getDeclaredConstructor().newInstance();
    }
}