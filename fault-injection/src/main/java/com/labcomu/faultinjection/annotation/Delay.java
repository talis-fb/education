package com.labcomu.faultinjection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.temporal.ChronoUnit;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Delay {
//    @Valid
//    @Min(0)
//    @Max(1)
    double threshold() default 1.0;

    ChronoUnit unit() default ChronoUnit.SECONDS;

    int value() default Integer.MAX_VALUE;
}
