package com.group.libraryapp.dto.book.request

data class BookLoanRequest constructor(
    val userName: String,
    val bookName: String,
)