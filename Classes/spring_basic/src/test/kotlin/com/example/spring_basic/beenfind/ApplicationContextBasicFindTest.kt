package com.example.spring_basic.beenfind

import com.example.spring_basic.AppConfig
import com.example.spring_basic.member.MemberService
import com.example.spring_basic.member.MemberServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextBasicFindTest {
    private val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    @DisplayName("빈 이름으로 조회")
    fun findBeanByName() {
        val memberService = applicationContext.getBean("memberService", MemberService::class.java)

        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    fun findBeanByType() {
        val memberService = applicationContext.getBean(MemberService::class.java)

        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    fun findBeanByName2() {
        val memberService = applicationContext.getBean("memberService", MemberServiceImpl::class.java)

        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }
}