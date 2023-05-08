package com.example.spring.httpinterface

import com.example.spring.common.logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/http")
class HttpController(
    private val bookService: BookService,
) {

    private val log = logger()

    @GetMapping("/books")
    fun getBooks(): List<Book> {
        log.info("HttpController")
        return bookService.getBooks()
    }

    @GetMapping("/book/{id}")
    fun getBook(@PathVariable id: Long): Book {
        return bookService.getBook(id)
    }
}