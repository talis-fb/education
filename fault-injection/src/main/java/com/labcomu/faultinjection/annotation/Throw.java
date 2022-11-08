package com.labcomu.faultinjection.annotation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Throw {
    @Min(0)
    @Max(1)
    double threshold() default -1;

    Class<? extends Exception> exception() default RuntimeException.class;
}
