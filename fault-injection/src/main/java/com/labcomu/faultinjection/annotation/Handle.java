package com.labcomu.faultinjection.annotation;

import com.labcomu.faultinjection.annotation.internal.Handles;
import com.labcomu.faultinjection.api.Handler;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.lang.annotation.*;

@Repeatable(Handles.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Handle {
    @Min(0)
    @Max(1)
    double threshold() default -1;

    @SuppressWarnings("rawtypes")
    Class<? extends Handler> handler();
}
