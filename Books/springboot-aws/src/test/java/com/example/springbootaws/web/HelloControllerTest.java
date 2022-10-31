package com.example.springbootaws.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @RunWith(SpringRunner.class)
 * ㄴ 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행
 * ㄴ SpringRunner라는 스프링 실행자를 사용
 * ㄴ 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역활
 */

/**
 * @WebMvcTest
 * ㄴ We(Spring MVC)에 집중할 수 있는 어노테이션
 * ㄴ 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있음
 * ㄴ @Service, @Component, @Repository 등은 사용할 수 없음
 * ㄴ JPA 기능이 작동하지 않음
 */

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    /**
     * MockMvc
     * ㄴ 웹 API 테스트할 때 사용
     * HTTP GET, POST 등에 대한 API 테스트를 할 수 있음
     */
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}