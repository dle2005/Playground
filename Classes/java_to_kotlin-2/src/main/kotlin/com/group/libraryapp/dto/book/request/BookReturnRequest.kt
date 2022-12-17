package com.group.libraryapp.dto.book.request

data class BookReturnRequest constructor(
    val userName: String,
    val bookName: String,
)