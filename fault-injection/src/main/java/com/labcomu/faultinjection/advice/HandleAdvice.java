package com.labcomu.faultinjection.advice;

import com.labcomu.faultinjection.annotation.Handle;
import com.labcomu.faultinjection.api.Handler;
import com.labcomu.faultinjection.util.AdviceUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
@ConditionalOnExpression("${aspect.enabled:true}")
@Slf4j
public class HandleAdvice {
    private final ApplicationContext context;

    public HandleAdvice(ApplicationContext context) {
        this.context = context;
    }

    @Around("@annotation(com.labcomu.faultinjection.annotation.Handle)")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
        Handle handle = AdviceUtil.init(Handle.class, log, point);

        Object value = point.proceed();

        doHandle(handle, value);

        return value;
    }
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void doHandle(Handle handle, Object value) {
        Handler handler = context.getBean(handle.handler());
        handler.handle(value);
    }
}