package com.example.spring_basic.order

import com.example.spring_basic.AppConfig
import com.example.spring_basic.member.Grade
import com.example.spring_basic.member.Member
import com.example.spring_basic.member.MemberService
import com.example.spring_basic.member.MemberServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class OrderServiceTest {
    private lateinit var memberService: MemberService
    private lateinit var orderService: OrderService

    @BeforeEach
    fun beforeEach() {
        val appConfig = AppConfig()
        memberService = appConfig.memberService()
        orderService = appConfig.oderService()
    }

    @Test
    fun createOrder() {
        val memberId = 1L
        val member = Member(memberId, "memberA", Grade.VIP)
        memberService.join(member)

        val order = orderService.createOrder(memberId, "itemA", 10000)

        Assertions.assertThat(order.discountPrice).isEqualTo(1000)
    }

}