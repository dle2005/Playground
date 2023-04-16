package com.example.spring_basic.beenfind

import com.example.spring_basic.member.MemberRepository
import com.example.spring_basic.member.MemoryMemberRepository
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ApplicationContextSameBeanFindTest {
    private val applicationContext = AnnotationConfigApplicationContext(SameBeanConfig::class.java)

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류 발생")
    fun findBeanByName() {
//        assertThrows(NoUniqueBeanDefinitionException::class.java) {
//            applicationContext.getBean(MemberRepository::class.java)
//        }
    }

    companion object {
        @Configuration
        class SameBeanConfig {
            @Bean
            fun memberRepository1() : MemberRepository {
                return MemoryMemberRepository()
            }

            @Bean
            fun memberRepository2() : MemberRepository {
                return MemoryMemberRepository()
            }
        }
    }

}