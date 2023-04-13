package com.example.spring_basic.discount

import com.example.spring_basic.member.Grade
import com.example.spring_basic.member.Member

class FixDiscountPolicy : DiscountPolicy {

    private val discountFixAmount = 1000

    override fun discount(member: Member, price: Int) : Int {
        return if (member.grade == Grade.VIP) discountFixAmount else 0
    }
}