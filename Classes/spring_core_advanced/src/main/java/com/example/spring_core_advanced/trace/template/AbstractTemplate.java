package com.example.spring_core_advanced.trace.template;

import com.example.spring_core_advanced.trace.TraceStatus;
import com.example.spring_core_advanced.trace.logtrace.LogTrace;

/**
 * 작업에서 알고리즘의 골격을 정의하고 일부 단계를 하위 클래스로 연기
 * 템플릿 메서드를 사용하면 하위 클래스가 알고리즘의 구조를 변경하지 않고도 알고리즘의 특정 단계를 재정의 할 수 있음
 *
 * 부모 클래스에 알고리즘의 골격인 템플릿을 정의하고, 일부 변경되는 로직은 자식 클래스에 정의
 * 자식 클래스가 알고리즘의 전체 구조를 변경하지 않고, 특정 부분만 재정의 할 수 있음
 * 상속과 오버라이딩을 통한 다형성으로 문제를 해결하는 것
 *
 * 하지만, 상속을 사용하여 상속에서 오는 단점들을 그대로 안고 간다
 * 자식 클래스가 부모 클래스와 컴파일 시점에 강하게 결합되는 의존관계에 대한 문제가 존재
 * 자식 클래스 입장에서는 부모 클래스의 기능을 전혀 사용하지 않음에도 템플릿 메서드 패턴을 위해 부모 클래스를 상속 받음
 */

public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    protected AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            // 로직 호출
            T result = call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);

            throw e;
        }
    }

    protected abstract T call();
}
