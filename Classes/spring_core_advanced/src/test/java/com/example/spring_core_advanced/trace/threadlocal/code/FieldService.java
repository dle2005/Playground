package com.example.spring_core_advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {

    private String nameStore;

    public void logic(String name) {
        log.info("저장 name={} -> nameStore={}", name, nameStore);

        nameStore = name;

        sleep();

        log.info("조회 nameStore={}", nameStore);

    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
