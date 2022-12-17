package com.group.libraryapp.dto.user.request

data class UserCreateRequest constructor(
    val name: String,
    val age: Int?,
)