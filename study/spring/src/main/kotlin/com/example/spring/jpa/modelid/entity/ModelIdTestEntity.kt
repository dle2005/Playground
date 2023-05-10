package com.example.spring.jpa.modelid.entity

import com.example.spring.jpa.modelid.model.ModelIdTestModel
import jakarta.persistence.AttributeOverride
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class ModelIdTestEntity(
    @Id
    @AttributeOverride(name = "value", column = Column(name = "TEST_MODEL", nullable = false, length = 10))
    val testModel: ModelIdTestModel,
)