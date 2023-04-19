package com.example.spring_basic.scope

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope

class PrototypeTest {

    @Test
    fun singletonBeanFind() {
        val ac = AnnotationConfigApplicationContext(PrototypeBean::class.java)

        val prototypeBean1 = ac.getBean(PrototypeBean::class.java)
        val prototypeBean2 = ac.getBean(PrototypeBean::class.java)

        println("singletonBean1 = ${prototypeBean1}")
        println("singletonBean2 = ${prototypeBean2}")

        assertThat(prototypeBean1).isNotSameAs(prototypeBean2)

        ac.close()
    }

    companion object {
        @Scope("prototype")
        class PrototypeBean {
            @PostConstruct
            fun init() {
                println("PrototypeBean.init")
            }

            @PreDestroy
            fun destroy() {
                println("PrototypeBean.destroy")
            }
        }
    }
}