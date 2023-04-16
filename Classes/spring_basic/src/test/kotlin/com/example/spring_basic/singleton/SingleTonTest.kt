package com.example.spring_basic.singleton

import com.example.spring_basic.AppConfig
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SingleTonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    fun pureContainer() {
        val appConfig = AppConfig()

        val memberService1 = appConfig.memberService()
        val memberService2 = appConfig.memberService()

        println("memberService1 = ${memberService1}")
        println("memberService2 = ${memberService2}")

        assertThat(memberService1).isNotSameAs(memberService2)
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    fun singletonServiceTest() {
        val singletonService1 = SingletonService.getInstance()
        val singletonService2 = SingletonService.getInstance()

        println("singletonService1 = ${singletonService1}")
        println("singletonService2 = ${singletonService2}")

        assertThat(singletonService1).isSameAs(singletonService2)
    }
}