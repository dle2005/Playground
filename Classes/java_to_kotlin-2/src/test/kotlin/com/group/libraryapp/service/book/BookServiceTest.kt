package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.book.BookType
import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus
import com.group.libraryapp.dto.book.request.BookLoanRequest
import com.group.libraryapp.dto.book.request.BookRequest
import com.group.libraryapp.dto.book.request.BookReturnRequest
import com.group.libraryapp.dto.book.response.BookStatResponse
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
        val request = BookRequest("홍길동전", BookType.COMPUTER)

        // when
        bookService.saveBook(request)

        // then
        val books = bookRepository.findAll()
        assertAll({
            assertThat(books).hasSize(1)
            assertThat(books[0].name).isEqualTo("홍길동전")
            assertThat(books[0].type).isEqualTo(BookType.COMPUTER)
        })
    }

    @Test
    fun loanBookTest() {
        // given
        bookRepository.save(Book.fixture("홍길동전"))
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
            assertThat(results[0].status).isEqualTo(UserLoanStatus.LOANED)
        })
    }

    @Test
    fun loanBookFailTest() {
        // given
        bookRepository.save(Book.fixture("홍길동전"))
        val savedUser = userRepository.save(User("홍길동", null))
        userLoanHistoryRepository.save(
            UserLoanHistory.fixture(
                savedUser,
                "홍길동전",
            )
        )
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
        bookRepository.save(Book.fixture("홍길동전"))
        val savedUser = userRepository.save(User("홍길동", null))
        userLoanHistoryRepository.save(
            UserLoanHistory.fixture(
                savedUser,
                "홍길동전",
            )
        )
        val request = BookReturnRequest("홍길동", "홍길동전")

        // when
        bookService.returnBook(request)

        // then
        val results = userLoanHistoryRepository.findAll()
        assertAll({
            assertThat(results).hasSize(1)
            assertThat(results[0].status).isEqualTo(UserLoanStatus.RETURNED)
        })
    }

    @Test
    fun countLoanedBookTest() {
        // given
        val savedUser = userRepository.save(User("A", null))
        userLoanHistoryRepository.saveAll(listOf(
            UserLoanHistory.fixture(savedUser, "A"),
            UserLoanHistory.fixture(savedUser, "B", UserLoanStatus.RETURNED),
            UserLoanHistory.fixture(savedUser, "C", UserLoanStatus.RETURNED),

        ))

        // when
        val result = bookService.countLoanBook()

        // then
        assertAll({
            assertThat(result).isEqualTo(1)
        })
    }

    @Test
    fun getBookStatisticsTest() {
        // given
        bookRepository.saveAll(listOf(
            Book.fixture("A", BookType.COMPUTER),
            Book.fixture("B", BookType.COMPUTER),
            Book.fixture("C", BookType.SCIENCE),
        ))

        // when
        val results = bookService.getBookStatistics()

        // then
        assertAll({
            assertThat(results).hasSize(2)
            assertCount(results, BookType.COMPUTER, 2L)
            assertCount(results, BookType.SCIENCE, 1L)
        })
    }

    private fun assertCount(result: List<BookStatResponse>, type: BookType, count: Long) {
        assertThat(result.first { result -> result.type == type }.count)
            .isEqualTo(count)
    }
}