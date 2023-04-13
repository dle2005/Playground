package com.example.spring_basic

import com.example.spring_basic.member.Grade
import com.example.spring_basic.member.Member

fun main() {
    val appConfig = AppConfig()

    val memberService = appConfig.memberService()
    val orderService = appConfig.oderService()

    val memberId = 1L
    val member = Member(memberId, "memberA", Grade.VIP)
    memberService.join(member)

    val order = orderService.createOrder(memberId, "itemA", 10000)

    println("order = ${order}")
    println("oder.calculatePrice = ${order.calculatePrice()}")
}