package com.example.spring_core_advanced.trace.strategy.code.strategy;

import com.example.spring_core_advanced.trace.strategy.code.strategy.ContextV1;
import com.example.spring_core_advanced.trace.strategy.code.strategy.Strategy;
import com.example.spring_core_advanced.trace.strategy.code.strategy.StrategyLogic1;
import com.example.spring_core_advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    /**
     * 템플릿 메서드 패턴은 부모 클래스에 변하지 않는 템플릿을 두고,
     * 변하는 부분을 자식 클래스에 두어서 상속을 사용해서 문제를 해결
     *
     * 전략 패턴은 변하지 않는 부분을 Context 라는 곳에 두고,
     * 변하는 부분을 Strategy 라는 인터페이스를 만들고
     * 해당 인터페이스를 구현해서 문제를 해결
     *
     * 상속이 아니라 위임으로 문제를 해결하는 것
     */
    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        contextV1 = new ContextV1(strategyLogic2);
        contextV1.execute();
    }

    @Test
    void strategyV2() {
        Strategy strategyLogic1 = () -> log.info("비즈니스 로직1 실행");
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        Strategy strategyLogic2 = () -> log.info("비즈니스 로직2 실행");
        contextV1 = new ContextV1(strategyLogic2);
        contextV1.execute();
    }
}
