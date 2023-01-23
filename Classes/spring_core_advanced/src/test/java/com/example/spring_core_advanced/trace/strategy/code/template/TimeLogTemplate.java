package com.example.spring_core_advanced.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback) {
        long startTime = System.currentTimeMillis();

        callback.call(); // 위임

        long resultTime = System.currentTimeMillis() - startTime;
        log.info("resultTime = {}", resultTime);
    }
}
