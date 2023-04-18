package com.example.spring_basic.lifecycle

import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class BeanLifeCycleTest {

    @Test
    fun lifeCycleTest() {
        val ac = AnnotationConfigApplicationContext(LifeCycleConfig::class.java)
        ac.getBean(NetworkClient::class.java)
        ac.close()
    }

    companion object {
        @Configuration
        class LifeCycleConfig {

            @Bean
            fun networkClient(): NetworkClient {
                val networkClient = NetworkClient()
                networkClient.setUrl("http://hello-spring.dev")
                return networkClient
            }
        }
    }


}