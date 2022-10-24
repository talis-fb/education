package com.labcomu.faultinjection.annotation.internal;

import com.labcomu.faultinjection.annotation.Mutate;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Mutates {
    Mutate[] value();
}
