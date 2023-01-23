package com.example.spring_core_advanced.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

/**
 * 전략을 파라미터로 전달 받는 방식
 */
@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();

        strategy.call(); // 위임

        long resultTime = System.currentTimeMillis() - startTime;
        log.info("resultTime = {}", resultTime);
    }
}
