package com.example.springbootaws.web;

import com.example.springbootaws.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController ㄴ 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 줌
 * ㄴ @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해줌
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /**
     * @RequestParam
     * ㄴ 외부에서 API로 넘김 파라미터를 가져오는 어노테이션
     */
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
