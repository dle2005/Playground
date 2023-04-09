package com.example.spring_basic

import com.example.spring_basic.member.Grade
import com.example.spring_basic.member.Member
import com.example.spring_basic.member.MemberServiceImpl

fun main() {
    val memberService = MemberServiceImpl()

    val member = Member(1, "A", Grade.VIP)
    memberService.join(member)

    val findMember = memberService.findMember(1)

    println(member == findMember)
}