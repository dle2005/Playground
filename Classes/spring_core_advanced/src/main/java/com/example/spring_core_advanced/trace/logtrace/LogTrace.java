package com.example.spring_core_advanced.trace.logtrace;

import com.example.spring_core_advanced.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
