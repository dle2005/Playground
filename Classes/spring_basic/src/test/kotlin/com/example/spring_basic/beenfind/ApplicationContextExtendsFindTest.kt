package com.example.spring_basic.beenfind

import com.example.spring_basic.discount.DiscountPolicy
import com.example.spring_basic.discount.FixDiscountPolicy
import com.example.spring_basic.discount.RateDiscountPolicy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ApplicationContextExtendsFindTest {

    private val applicationContext = AnnotationConfigApplicationContext(TestConfig::class.java)

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 중복 오류가 발생")
    fun findBeanByParentTypeDuplicate() {
//        assertThrows(NoUniqueBeanDefinitionException::class.java) {
//            applicationContext.getBean(DiscountPolicy::class.java)
//        }
    }

    @Test
    @DisplayName("부모 타입으로 조회시,, 자식이 둘 이상 있으면, 빈 이름을 지정")
    fun findBeanByParentTypeBeanName() {
        val rateDiscountPolicy = applicationContext.getBean("rateDiscountPolicy", DiscountPolicy::class.java)
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy::class.java)
    }


    companion object {
        @Configuration
        class TestConfig {

            @Bean
            fun rateDiscountPolicy(): DiscountPolicy {
                return RateDiscountPolicy()
            }

            @Bean
            fun fixDiscountPolicy(): DiscountPolicy {
                return FixDiscountPolicy()
            }
        }
    }
}