package com.example.spring_introduction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    /**
     * 컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버(viewResolver)가 화면을 찾아서 처리
     * 스프링 부트 템플릿엔진 기본 viewName 매핑
     * resources:templates/ + {viewName} + .html
     *
     * 참고: spring-bbot-devtools 라이브러리를 추가하면, html 파일을 컴파일만 해주면
     * 서버 재시작 없이 View 파일 변경이 가능
     * Intellij 컴파일 방법: 메뉴 build -> Recompile
     */
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");

        return "hello";
    }

    /**
     * 정적 컨텐츠 이미지의 경우 스프링 컨테이너에서 해당 URL 컨트롤러를 찾지 못한다면
     * 내장 톰켓 서버가 resources에서 해당 이름의 html 파일을 찾아 웹 브라우저로 제공
     *
     * ex. http://localhost:8080/hello-static.html
     * -> resources: static/hello-static.html
     */

    /**
     * MVC 동작 방식
     */
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);

        return "hello-template";
    }

    /**
     * @ResponseBody를 사용하면 뷰 리졸버(viewResolver)를 사용하지 않음
     * 대신에 HTTP의 BODY에 문자 내용을 직접 반환
     */
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    /**
     * @ResponseBody를 사용하고, 객체를 반환하면 객체가 JSON으로 반환됨
     * viewResolver대신에 HttpMessageConverter가 동작
     *
     * HttpMessageConverter
     * ㄴ 기본 문자처리 : StringHttpMessageConverter
     * ㄴ 기본 객체처리 : MappingJackson2HttpMessageConverter
     * ㄴ byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록
     */
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }

    private static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
