package com.group.libraryapp.domain.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>, UserRepositoryCustom {

    fun findByName(name: String): User?

//    @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.userLoanHistories")
//    fun findAllWithHistories(): List<User>
}