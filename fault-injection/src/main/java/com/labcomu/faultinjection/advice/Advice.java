package com.labcomu.faultinjection.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;

import java.lang.annotation.Annotation;

public abstract class Advice<A extends Annotation> {
    protected Object advice(Class<A> clazz, Logger log, ProceedingJoinPoint point) throws Throwable {
        A annotation = init(clazz, log, point);

        return threshold(annotation) < Math.random() ? apply(annotation, point) : point.proceed();
    }

    private A init(Class<A> clazz, Logger log, ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();

        log.debug("'{}.{}' intercepted", signature.getDeclaringTypeName(), signature.getName());

        return signature.getMethod().getAnnotation(clazz);
    }

    protected abstract double threshold(A annotation);

    protected abstract Object apply(A annotation, ProceedingJoinPoint point) throws Throwable;
}