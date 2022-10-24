package com.labcomu.faultinjection.advice;

import com.labcomu.faultinjection.annotation.Mutate;
import com.labcomu.faultinjection.util.AdviceUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
@ConditionalOnExpression("${aspect.enabled:true}")
@Slf4j
public class MutateAdvice {
    private final SpelExpressionParser parser;

    public MutateAdvice(SpelExpressionParser parser) {
        this.parser = parser;
    }

    @Around("@annotation(com.labcomu.faultinjection.annotation.Mutate)")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
        Mutate mutate = AdviceUtil.init(Mutate.class, log, point);

        Object value = point.proceed();

        doMutate(mutate, value);

        return value;
    }

    public void doMutate(Mutate mutate, Object value) {
        parser.parseExpression(mutate.field()).setValue(new StandardEvaluationContext(value), mutate.set());
    }
}