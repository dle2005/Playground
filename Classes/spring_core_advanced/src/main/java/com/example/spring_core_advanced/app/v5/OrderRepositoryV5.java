package com.example.spring_core_advanced.app.v5;

import com.example.spring_core_advanced.trace.callback.TraceTemplate;
import com.example.spring_core_advanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate traceTemplate;

    public OrderRepositoryV5(LogTrace logTrace) {
        this.traceTemplate = new TraceTemplate(logTrace);
    }

    public void save(String itemId) {
        traceTemplate.execute("OrderRepository.save()", () -> {
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생");
            }
            sleep();
            return null;
        });
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
