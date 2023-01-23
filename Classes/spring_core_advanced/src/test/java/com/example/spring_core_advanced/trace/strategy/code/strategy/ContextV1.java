package com.example.spring_core_advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 필드에 전략을 보관하는 방식
 */
@Slf4j
public class ContextV1 {

    private final Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();

        strategy.call(); // 위임

        long resultTime = System.currentTimeMillis() - startTime;
        log.info("resultTime = {}", resultTime);
    }
}
