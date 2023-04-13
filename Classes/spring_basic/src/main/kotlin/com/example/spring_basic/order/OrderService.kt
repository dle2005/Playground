package com.example.spring_basic.order

interface OrderService {
    fun createOrder(
        memberId: Long,
        itemName: String,
        itemPrice: Int,
    ) : Order
}