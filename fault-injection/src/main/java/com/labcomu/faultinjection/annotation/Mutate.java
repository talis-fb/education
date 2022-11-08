package com.labcomu.faultinjection.annotation;

import com.labcomu.faultinjection.annotation.internal.Mutates;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.lang.annotation.*;

@Repeatable(Mutates.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Mutate {
    @Min(0)
    @Max(1)
    double threshold() default -1;

    String field();

    String set();
}
