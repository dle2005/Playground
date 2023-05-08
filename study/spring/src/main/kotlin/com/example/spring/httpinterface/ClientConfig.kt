package com.example.spring.httpinterface

import jakarta.servlet.http.HttpServletRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class ClientConfig(
    val httpServletRequest: HttpServletRequest
) {

    @Bean
    fun bookService(webClient: WebClient): BookService {
        return HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build()
            .createClient(BookService::class.java)
    }

    @Bean
    fun webClient() : WebClient {
        return WebClient.builder()
            .baseUrl("http://localhost:8080")
            .build()
    }
}