package com.example.spring_basic

import com.example.spring_basic.member.Grade
import com.example.spring_basic.member.Member

fun main() {
    val appConfig = AppConfig()

    val memberService = appConfig.memberService()

    val member = Member(1, "A", Grade.VIP)
    memberService.join(member)

    val findMember = memberService.findMember(1)

    println(member == findMember)
}