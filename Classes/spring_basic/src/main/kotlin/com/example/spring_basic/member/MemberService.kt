package com.example.spring_basic.member

interface MemberService {

    fun join(member: Member)

    fun findMember(memberId: Long) : Member?
}