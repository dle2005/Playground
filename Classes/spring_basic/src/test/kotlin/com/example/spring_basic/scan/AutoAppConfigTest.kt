package com.example.spring_basic.scan

import com.example.spring_basic.AutoAppConfig
import com.example.spring_basic.member.MemberService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class AutoAppConfigTest {

    @Test
    fun basicScan() {
        val ac = AnnotationConfigApplicationContext(AutoAppConfig::class.java)

        val memberService = ac.getBean(MemberService::class.java)
        Assertions.assertThat(memberService).isInstanceOf(MemberService::class.java)
    }

}