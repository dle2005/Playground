package com.example.spring_core_advanced.trace.template;

import com.example.spring_core_advanced.trace.template.code.AbstractTemplate;
import com.example.spring_core_advanced.trace.template.code.SubClassLogic1;
import com.example.spring_core_advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 템플릿 메서드 패턴을 사용해서 변하는 부분과 변하지 않는 부분을 분리
 * 변하는 부분: 비즈니스 로직
 * 변하지 않는 부분: 시간 측정
 *
 * 템플릿이라는 틀에 변하지 않는 부분을 몰아둔다.
 * 그리고 변하는 부분을 별도로 호출하여 해결
 */

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV2() {
        AbstractTemplate template3 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직3 실행");
            }
        };
        template3.execute();
    }

    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스 로직1 실행");

        long resultTime = System.currentTimeMillis() - startTime;
        log.info("resultTime = {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스 로직2 실행");

        long resultTime = System.currentTimeMillis() - startTime;
        log.info("resultTime = {}", resultTime);
    }
}
