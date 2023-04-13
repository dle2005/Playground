package com.example.spring_basic.order

import com.example.spring_basic.discount.FixDiscountPolicy
import com.example.spring_basic.member.MemoryMemberRepository

class OrderServiceImpl : OrderService {

    private val memberRepository = MemoryMemberRepository()
    private val discountPolicy = FixDiscountPolicy()

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member = memberRepository.findById(memberId)
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}