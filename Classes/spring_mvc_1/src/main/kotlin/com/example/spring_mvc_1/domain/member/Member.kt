package com.example.spring_mvc_1.domain.member

data class Member(
    var id: Long,
    val username: String,
    val age: Int,
) {
    constructor(username: String, age: Int) : this(0L, username, age)
}