package com.labcomu.faultinjection.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Delay {
    @AliasFor("seconds")
    int value() default Integer.MAX_VALUE;

    @AliasFor("value")
    int seconds() default Integer.MAX_VALUE;
}
