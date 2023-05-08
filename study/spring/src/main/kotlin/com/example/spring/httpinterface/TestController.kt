package com.example.spring.httpinterface

import com.example.spring.common.logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {

    private val log = logger()

    @GetMapping("/books")
    fun getBooks(): List<Book> {
        log.info("TestController")
        return listOf(Book(1, "book1"))
    }

    @GetMapping("/book/{id}")
    fun getBook(@PathVariable id: Long): Book {
        return Book(1, "book1")
    }
}