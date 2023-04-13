package com.example.spring_basic.discount

import com.example.spring_basic.member.Member

interface DiscountPolicy {

    fun discount(member: Member, price: Int) : Int
}