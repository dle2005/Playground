package com.example.spring_basic

import com.example.spring_basic.member.Grade
import com.example.spring_basic.member.Member
import com.example.spring_basic.member.MemberService
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun memberApp() {
    val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val memberService = applicationContext.getBean("memberService", MemberService::class.java)

    val member = Member(1, "A", Grade.VIP)
    memberService.join(member)

    val findMember = memberService.findMember(1)

    println(member == findMember)
}