package com.example.spring_core_advanced.trace.strategy.code.template;

/**
 * 프로그래밍에서 콜백(callback) 또는 콜애프터 함수(call-after function)는
 * 다른 코드의 인수로서 넘겨주는 실행 가능한 코드를 말한다.
 * 콜백을 넘겨받는 코드는 이 콜백을 필요에 따라 즉시 실행할 수도 있고, 아니면 나중에 실행할 수 있다.
 *
 * callback 은 코드가 호출(call) 은 되는데 코드를 넘겨준 곳의 뒤(back) 에서 실행
 * ContextV2 예제에서 콜백을 strategy 이다.
 * Strategy 를 직접 실행하는 것이 아니라, ContextV2.execute(...) 를 실행할 때
 * strategy 를 념겨주고, ContextV2 뒤에서 strategy 가 실행
 *
 * 스프링에서는 ContextV2 와 같은 방식의 전략 패턴을 템플릿 콜백 패턴이라 한다.
 * Context 가 템플릿 역활을 하고, Strategy 부분이 콜백으로 넘어온다 생각하면 된다.
 *
 * 템플릿 콜백 패턴은 GOF 패턴은 아니고, 스프링 내부에서 이런 방식을 자주 사용하기 때문에,
 * 스프링 안에서만 이렇게 부른다. 전략 패턴에서 템플릿과 콜백 부분이 강조된 패턴이라 생각하면 된다.
 *
 * 스프링에서는 JdbcTemplate, RestTemplate, TransactionTemplate, RedisTemplate 처럼
 * 다양한 템플릿 콜백 패턴이 사용된다. 이름에 xxxTemplate 가 있다면 템플릿 콜백 패턴
 */

public interface Callback {
    void call();
}
