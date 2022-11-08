package com.labcomu.faultinjection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.temporal.ChronoUnit;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Delay {
    double threshold() default -1;

    ChronoUnit unit() default ChronoUnit.SECONDS;

    int value() default Integer.MAX_VALUE;
}
