package com.labcomu.faultinjection.annotation;

import com.labcomu.faultinjection.api.Mutator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Mutate {
    @SuppressWarnings("rawtypes")
    Class<? extends Mutator> value();
}
