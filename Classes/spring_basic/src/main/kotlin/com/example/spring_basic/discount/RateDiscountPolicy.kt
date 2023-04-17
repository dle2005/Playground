package com.example.spring_basic.discount

import com.example.spring_basic.member.Grade
import com.example.spring_basic.member.Member
import org.springframework.stereotype.Component

@Component
class RateDiscountPolicy : DiscountPolicy {

    private val discountPercent = 10

    override fun discount(member: Member, price: Int): Int {
        return if (member.grade == Grade.VIP) price * discountPercent / 100 else 0
    }

}