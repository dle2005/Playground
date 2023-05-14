package com.example.spring_jpa_basic.dirtychecking

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.jpa.repository.JpaRepository

@Entity
data class DirtyCheckingTestEntity(
    @Column(length = 255)
    var value: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
)

interface DirtyCheckingTestRepository : JpaRepository<DirtyCheckingTestEntity, Long>