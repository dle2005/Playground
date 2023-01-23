package com.example.spring_core_advanced.trace.callback;

public interface TraceCallback<T> {
    T call();
}
