package com.example.spring_mvc_1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@ServletComponentScan // 서블릿 자동 등록
@SpringBootApplication
class SpringMvc1Application

fun main(args: Array<String>) {
	runApplication<SpringMvc1Application>(*args)
}
