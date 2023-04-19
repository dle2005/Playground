package com.example.spring_basic.scope

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.ObjectProvider
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope

class SingletonWithPrototypeTest1 {

    @Test
    fun prototypeFind() {
        val ac = AnnotationConfigApplicationContext(PrototypeBean::class.java)

        val prototypeBean1 = ac.getBean(PrototypeBean::class.java)
        prototypeBean1.addCount()
        assertThat(prototypeBean1.count).isEqualTo(1)

        val prototypeBean2 = ac.getBean(PrototypeBean::class.java)
        prototypeBean2.addCount()
        assertThat(prototypeBean2.count).isEqualTo(1)
    }

    @Test
    fun singletonClientUsePrototype() {
        val ac = AnnotationConfigApplicationContext(ClientBean::class.java, PrototypeBean::class.java)

        val clientBean1 = ac.getBean(ClientBean::class.java)
        val count1 = clientBean1.logic()
        assertThat(count1).isEqualTo(1)

        val clientBean2 = ac.getBean(ClientBean::class.java)
        val count2 = clientBean2.logic()
        assertThat(count2).isEqualTo(1)
    }

    companion object {
        @Scope("singleton")
        class ClientBean(
            private val prototypeBeanProvider: ObjectProvider<PrototypeBean>
        ) {
            fun logic(): Int {
                val prototypeBean = prototypeBeanProvider.`object`
                prototypeBean.addCount()
                return prototypeBean.count
            }
        }

        @Scope("prototype")
        class PrototypeBean {
            var count = 0
                private set

            fun addCount() {
                count++
            }

            @PostConstruct
            fun init() {
                println("PrototypeBean.init ${this}")
            }

            @PreDestroy
            fun destroy() {
                println("PrototypeBean.destroy")
            }
        }
    }
}