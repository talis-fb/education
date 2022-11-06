package com.labcomu.faultinjection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Throw {
    float threshold() default 1f;

    Class<? extends Exception> exception() default RuntimeException.class;
}
