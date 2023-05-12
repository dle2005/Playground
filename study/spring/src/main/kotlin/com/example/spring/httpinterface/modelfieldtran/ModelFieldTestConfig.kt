package com.example.spring.httpinterface.modelfieldtran

import jakarta.servlet.http.HttpServletRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class ModelFieldTestConfig(
    val httpServletRequest: HttpServletRequest
) {

    @Bean
    fun modelFieldTestService(webClient: WebClient): ModelFieldTestService {
        return HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build()
            .createClient(ModelFieldTestService::class.java)
    }

}