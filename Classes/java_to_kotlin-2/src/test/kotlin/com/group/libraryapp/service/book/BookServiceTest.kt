package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.group.libraryapp.dto.book.request.BookLoanRequest
import com.group.libraryapp.dto.book.request.BookRequest
import com.group.libraryapp.dto.book.request.BookReturnRequest
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookServiceTest @Autowired constructor(
    private val bookService: BookService,
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryRepository
) {

    @AfterEach
    fun clean() {
        bookRepository.deleteAll()
        userRepository.deleteAll()
    }

    @Test
    fun saveBook() {
        // given
        val request = BookRequest("홍길동전")

        // when
        bookService.saveBook(request)

        // then
        val books = bookRepository.findAll()
        assertAll({
            assertThat(books).hasSize(1)
            assertThat(books[0].name).isEqualTo("홍길동전")
        })
    }

    @Test
    fun loanBookTest() {
        // given
        bookRepository.save(Book("홍길동전"))
        val savedUser = userRepository.save(User("홍길동", null))
        val request = BookLoanRequest("홍길동", "홍길동전")

        // when
        bookService.loanBook(request)

        // then
        val results = userLoanHistoryRepository.findAll()
        assertAll({
            assertThat(results).hasSize(1)
            assertThat(results[0].bookName).isEqualTo("홍길동전")
            assertThat(results[0].user.id).isEqualTo(savedUser.id)
            assertThat(results[0].isReturn).isFalse()
        })
    }

    @Test
    fun loanBookFailTest() {
        // given
        bookRepository.save(Book("홍길동전"))
        val savedUser = userRepository.save(User("홍길동", null))
        userLoanHistoryRepository.save(UserLoanHistory(savedUser, "홍길동전", false))
        val request = BookLoanRequest("홍길동", "홍길동전")

        // when & then
        val message = assertThrows<IllegalArgumentException> {
            bookService.loanBook(request)
        }.message
        assertThat(message).isEqualTo("진작 대출되어 있는 책입니다")
    }

    @Test
    fun returnBookTest() {
        // given
        bookRepository.save(Book("홍길동전"))
        val savedUser = userRepository.save(User("홍길동", null))
        userLoanHistoryRepository.save(UserLoanHistory(savedUser, "홍길동전", false))
        val request = BookReturnRequest("홍길동", "홍길동전")

        // when
        bookService.returnBook(request)

        // then
        val results = userLoanHistoryRepository.findAll()
        assertAll({
            assertThat(results).hasSize(1)
            assertThat(results[0].isReturn).isTrue()
        })
    }
}