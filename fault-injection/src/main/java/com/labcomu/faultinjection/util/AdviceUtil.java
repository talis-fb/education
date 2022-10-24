package com.labcomu.faultinjection.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;

import java.lang.annotation.Annotation;

public class AdviceUtil {
    public static <T extends Annotation> T init(Class<T> clazz, Logger log, ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();

        log.debug("'{}.{}' intercepted", signature.getDeclaringTypeName(), signature.getName());

        return signature.getMethod().getAnnotation(clazz);
    }
}
