package com.example.spring_basic.order

import com.example.spring_basic.annotation.MainDiscountPolicy
import com.example.spring_basic.discount.DiscountPolicy
import com.example.spring_basic.member.MemberRepository
import org.springframework.stereotype.Component

@Component
class OrderServiceImpl (
    private val memberRepository: MemberRepository,
    @MainDiscountPolicy private val discountPolicy: DiscountPolicy
) : OrderService {

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member = memberRepository.findById(memberId)
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }

    fun getMemberRepository() : MemberRepository {
        return memberRepository
    }
}