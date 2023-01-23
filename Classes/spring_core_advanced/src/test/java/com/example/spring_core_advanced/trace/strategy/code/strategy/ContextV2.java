package com.example.spring_core_advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * ContextV2는 변하지 않는 템플릿 역활
 * 변하는 부분은 파라미터로 넘어온 Strategy 의 코드를 실행해서 처리
 * 이렇게 다른 코드의 인수로서 넘겨주는 실행 가능한 코드를 콜백(callback)이라 한다.
 */

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
