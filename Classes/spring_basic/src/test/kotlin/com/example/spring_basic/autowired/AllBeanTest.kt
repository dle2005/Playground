package com.example.spring_basic.autowired

import com.example.spring_basic.AutoAppConfig
import com.example.spring_basic.discount.DiscountPolicy
import com.example.spring_basic.member.Grade
import com.example.spring_basic.member.Member
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class AllBeanTest {

    @Test
    fun findAllBean() {
        val ac = AnnotationConfigApplicationContext(AutoAppConfig::class.java, DiscountService::class.java)

        val discountService = ac.getBean(DiscountService::class.java)
        val member = Member(1L, "userA", Grade.VIP)
        val discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy")

        assertThat(discountService).isInstanceOf(DiscountService::class.java)
        assertThat(discountPrice).isEqualTo(1000)
    }

    companion object {
        class DiscountService @Autowired constructor(
            private val policyMap: Map<String, DiscountPolicy>,
            policies: List<DiscountPolicy>
        ) {
            fun discount(member: Member, price: Int, discountCode: String): Int {
                val discountPolicy = policyMap[discountCode]
                return discountPolicy!!.discount(member, price)
            }

            init {
                println("policyMap = $policyMap")
                println("policies = $policies")
            }
        }
    }
}