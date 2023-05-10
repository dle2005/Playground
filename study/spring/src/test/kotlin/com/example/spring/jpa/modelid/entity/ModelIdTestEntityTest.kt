package com.example.spring.jpa.modelid.entity

import com.example.spring.jpa.modelid.model.ModelIdTestModel
import com.example.spring.jpa.modelid.repository.ModelIdTestRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class ModelIdTestEntityTest @Autowired constructor(
    private val modelIdTestRepository: ModelIdTestRepository,
) {

    @Test
    fun testEntityPersistence() {
        val testModel = ModelIdTestModel("12345")
        val testEntity = ModelIdTestEntity(testModel)
        modelIdTestRepository.save(testEntity)

        val retrievedEntity = modelIdTestRepository.findById(testModel).get()
        assertEquals(testModel.value, retrievedEntity.testModel.value)
    }
}