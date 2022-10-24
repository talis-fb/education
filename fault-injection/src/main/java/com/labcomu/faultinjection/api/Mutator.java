package com.labcomu.faultinjection.api;

public interface Mutator<T> {
    void mutate(T value);
}
