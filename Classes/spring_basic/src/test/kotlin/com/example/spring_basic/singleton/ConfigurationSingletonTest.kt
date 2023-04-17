package com.example.spring_basic.singleton

import com.example.spring_basic.AppConfig
import com.example.spring_basic.member.MemberRepository
import com.example.spring_basic.member.MemberServiceImpl
import com.example.spring_basic.order.OrderServiceImpl
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ConfigurationSingletonTest {

    @Test
    fun configurationTest() {
        val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)

        val memberService = applicationContext.getBean("memberService", MemberServiceImpl::class.java)
        val orderService = applicationContext.getBean("orderService", OrderServiceImpl::class.java)

        val memberRepository = applicationContext.getBean("memberRepository", MemberRepository::class.java)
        val memberRepository1 = memberService.getMemberRepository()
        val memberRepository2 = orderService.getMemberRepository()

        println("memberRepository = ${memberRepository}")
        println("memberService -> memberRepository = ${memberRepository1}")
        println("orderService -> memberRepository = ${memberRepository2}")
    }
}