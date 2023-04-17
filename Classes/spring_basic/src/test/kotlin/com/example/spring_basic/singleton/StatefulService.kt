package com.example.spring_basic.singleton

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean

class StatefulService {

    var price = 0

    fun order(name: String, price: Int) {
        println("name ${name} price ${price}")
        this.price = price
    }
}

class StatefulServiceTest {

    @Test
    fun statefulServiceSingleton() {
        val applicationContext = AnnotationConfigApplicationContext(TestConfig::class.java)

        val statefulService1 = applicationContext.getBean(StatefulService::class.java)
        val statefulService2 = applicationContext.getBean(StatefulService::class.java)

        statefulService1.order("userA", 10000)
        statefulService2.order("userB", 20000)

        val price = statefulService1.price
        println("price = ${price}")

        assertThat(statefulService1.price).isEqualTo(20000)
    }

    companion object {
        class TestConfig {
            @Bean
            fun statefulService() : StatefulService {
                return StatefulService()
            }
        }
    }
}