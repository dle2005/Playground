package com.example.spring.jpa.mappedsuperclass

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseTimeEntity {

    @CreationTimestamp
    @Column(name = "CREATED_DATETIME", nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()

    @UpdateTimestamp
    @Column(name = "CHANGED_DATETIME", nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
}