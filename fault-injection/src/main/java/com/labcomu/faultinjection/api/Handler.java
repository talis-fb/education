package com.labcomu.faultinjection.api;

public interface Handler<T> {
    void handle(T value);
}
