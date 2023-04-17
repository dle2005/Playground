package com.example.spring_basic.singleton

import com.example.spring_basic.AppConfig
import com.example.spring_basic.member.MemberService
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

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

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    fun springContainer() {
        val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)

        val memberService1 = applicationContext.getBean("memberService", MemberService::class.java)
        val memberService2 = applicationContext.getBean("memberService", MemberService::class.java)

        println("memberService1 = ${memberService1}")
        println("memberService2 = ${memberService2}")

        assertThat(memberService1).isSameAs(memberService2)
    }
}