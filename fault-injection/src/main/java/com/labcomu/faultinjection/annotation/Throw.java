package com.labcomu.faultinjection.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Throw {
    @AliasFor("value")
    Class<? extends Exception> exception() default RuntimeException.class;

    @AliasFor("exception")
    Class<? extends Exception> value() default RuntimeException.class;
}
