package com.labcomu.faultinjection.advice;

import com.labcomu.faultinjection.annotation.Delay;
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
public class DelayAdvice {
    @Around("@annotation(com.labcomu.faultinjection.annotation.Delay)")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
        Delay delay = AdviceUtil.init(Delay.class, log, point);

        int seconds = delay.seconds();

        Thread.sleep(seconds * 1000L);

        return point.proceed();
    }
}