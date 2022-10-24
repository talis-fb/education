package com.labcomu.faultinjection.annotation;

import com.labcomu.faultinjection.annotation.internal.Mutates;

import java.lang.annotation.*;

@Repeatable(Mutates.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Mutate {
    String field();

    String set();
}
