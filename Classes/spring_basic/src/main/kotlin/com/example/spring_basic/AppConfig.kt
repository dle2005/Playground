package com.example.spring_basic

import com.example.spring_basic.discount.DiscountPolicy
import com.example.spring_basic.discount.FixDiscountPolicy
import com.example.spring_basic.member.MemberRepository
import com.example.spring_basic.member.MemberService
import com.example.spring_basic.member.MemberServiceImpl
import com.example.spring_basic.member.MemoryMemberRepository
import com.example.spring_basic.order.OrderService
import com.example.spring_basic.order.OrderServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun memberRepository(): MemberRepository {
        return MemoryMemberRepository()
    }

    @Bean
    fun discountPolicy(): DiscountPolicy {
        return FixDiscountPolicy()
    }

    @Bean
    fun memberService(): MemberService {
        return MemberServiceImpl(memberRepository())
    }

    @Bean
    fun oderService(): OrderService {
        return OrderServiceImpl(memberRepository(), discountPolicy())
    }

}