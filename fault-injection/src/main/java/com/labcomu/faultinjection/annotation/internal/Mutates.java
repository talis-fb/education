package com.labcomu.faultinjection.annotation.internal;

import com.labcomu.faultinjection.annotation.Mutate;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Mutates {
    float threshold() default 1f;

    Mutate[] value();
}
