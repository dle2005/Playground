package com.example.spring_core_advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {

    private String nameStore;

    public void logic(String name) {
        log.info("์ ์ฅ name={} -> nameStore={}", name, nameStore);

        nameStore = name;

        sleep();

        log.info("์กฐํ nameStore={}", nameStore);

    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
