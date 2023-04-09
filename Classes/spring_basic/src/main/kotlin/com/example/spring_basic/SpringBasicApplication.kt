package com.example.spring_basic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBasicApplication

fun main(args: Array<String>) {
	runApplication<SpringBasicApplication>(*args)
}
