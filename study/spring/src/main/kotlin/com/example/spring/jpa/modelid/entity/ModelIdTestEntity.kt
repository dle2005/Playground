package com.example.spring.jpa.modelid.entity

import com.example.spring.jpa.modelid.enum.JpaTestCode
import com.example.spring.jpa.modelid.enum.JpaTestCodeConverter
import com.example.spring.jpa.modelid.enum.JpaTestCodeConverter2
import com.example.spring.jpa.modelid.model.ModelIdTestModel
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@IdClass(MultiId::class)
data class ModelIdTestEntity(
    @Id
    @AttributeOverride(name = "value", column = Column(name = "TEST_MODEL", nullable = false, length = 10))
    val testModel: ModelIdTestModel,

    @Id
    val multiId: String,

    @Convert(converter = JpaTestCodeConverter2::class)
    @Column(name = "TEST_CODE", length = 4)
    var testCode: JpaTestCode? = null,

    var defaultValue: String = "default",

    @CreationTimestamp
    @Column(name = "CREATED_DATETIME", nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)