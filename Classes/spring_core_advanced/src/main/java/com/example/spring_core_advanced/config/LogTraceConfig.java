package com.example.spring_core_advanced.config;

import com.example.spring_core_advanced.trace.logtrace.LogTrace;
import com.example.spring_core_advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
