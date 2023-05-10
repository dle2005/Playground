package com.example.spring.jpa.mappedsuperclass

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestRepository : JpaRepository<TestEntity, Long> {
}