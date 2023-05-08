package com.example.spring.httpinterface

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.service.annotation.DeleteExchange
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.PostExchange

interface BookService {

    @GetExchange("/test/books")
    fun getBooks(): List<Book>

    @GetExchange("/test/book/{id}")
    fun getBook(@PathVariable id: Long): Book

    @PostExchange("/test/books")
    fun saveBook(@RequestBody book: Book): Book

    @DeleteExchange("/test/books/{id}")
    fun deleteBook(@PathVariable id: Long): ResponseEntity<Void>
}