package com.example.spring_basic

import com.example.spring_basic.member.Grade
import com.example.spring_basic.member.Member
import com.example.spring_basic.member.MemberService
import com.example.spring_basic.order.OrderService
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun orderApp() {
    val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val memberService = applicationContext.getBean("memberService", MemberService::class.java)
    val orderService = applicationContext.getBean("orderService", OrderService::class.java)

    val memberId = 1L
    val member = Member(memberId, "memberA", Grade.VIP)
    memberService.join(member)

    val order = orderService.createOrder(memberId, "itemA", 10000)

    println("order = ${order}")
    println("oder.calculatePrice = ${order.calculatePrice()}")
}