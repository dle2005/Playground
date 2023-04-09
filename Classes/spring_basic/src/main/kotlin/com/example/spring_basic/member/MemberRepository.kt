package com.example.spring_basic.member

interface MemberRepository {

    fun save(member: Member)

    fun findById(memberId: Long) : Member?
}