package com.example.spring_basic

import com.example.spring_basic.discount.FixDiscountPolicy
import com.example.spring_basic.member.MemberService
import com.example.spring_basic.member.MemberServiceImpl
import com.example.spring_basic.member.MemoryMemberRepository
import com.example.spring_basic.order.OrderService
import com.example.spring_basic.order.OrderServiceImpl

class AppConfig {

    fun memberService(): MemberService {
        return MemberServiceImpl(MemoryMemberRepository())
    }

    fun oderService(): OrderService {
        return OrderServiceImpl(MemoryMemberRepository(), FixDiscountPolicy())
    }

}