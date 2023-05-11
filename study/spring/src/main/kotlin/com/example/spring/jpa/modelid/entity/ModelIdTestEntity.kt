package com.example.spring.jpa.modelid.entity

import com.example.spring.jpa.modelid.enum.JpaTestCode
import com.example.spring.jpa.modelid.enum.JpaTestCodeConverter
import com.example.spring.jpa.modelid.model.ModelIdTestModel
import jakarta.persistence.*

@Entity
data class ModelIdTestEntity(
    @Id
    @AttributeOverride(name = "value", column = Column(name = "TEST_MODEL", nullable = false, length = 10))
    val testModel: ModelIdTestModel,

    @Convert(converter = JpaTestCodeConverter::class)
    @Column(name = "TEST_CODE", length = 4)
    val testCode: JpaTestCode,
)