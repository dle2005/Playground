package com.example.spring_basic.common

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component
import java.util.UUID

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
class MyLogger {
    private var uuid: String = ""
    private var requestURL: String = ""

    fun setRequestURL(requestURL: String) {
        this.requestURL = requestURL
    }

    fun log(message: String) {
        println("[${uuid}] [${requestURL}] ${message}")
    }

    @PostConstruct
    fun init() {
        this.uuid = UUID.randomUUID().toString()
        println("[${uuid}] request scope bean create: ${this}")
    }

    @PreDestroy
    fun close() {
        println("[${uuid}] request scope bean close: ${this}")
    }
}