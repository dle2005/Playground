package com.example.spring.jpa.modelid.entity

import com.example.spring.jpa.modelid.enum.JpaTestCode
import com.example.spring.jpa.modelid.model.ModelIdTestModel
import com.example.spring.jpa.modelid.repository.ModelIdTestRepository
import org.assertj.core.api.Assertions
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
        val multiId = MultiId(testModel, "test")
        val testEntity = ModelIdTestEntity(testModel, "test")
        modelIdTestRepository.save(testEntity)

        val retrievedEntity = modelIdTestRepository.findById(multiId).get()
        println(retrievedEntity)
        assertEquals(testModel.value, retrievedEntity.testModel.value)
    }

    @Test
    fun defaultValueTest() {
        val testModel = ModelIdTestModel("12345")
        val multiId = MultiId(testModel, "test")
        val testEntity = ModelIdTestEntity(testModel, "test", JpaTestCode.SUCCESS)
        modelIdTestRepository.save(testEntity)

        val retrievedEntity = modelIdTestRepository.findById(multiId).get()
        Assertions.assertThat(retrievedEntity.defaultValue).isEqualTo("default")
    }

    @Test
    fun defaultValueTest2() {
        val testModel = ModelIdTestModel("12345")
        val multiId = MultiId(testModel, "test")
        val testEntity = ModelIdTestEntity(testModel, "test", JpaTestCode.SUCCESS, "not default")
        modelIdTestRepository.save(testEntity)

        val retrievedEntity = modelIdTestRepository.findById(multiId).get()
        Assertions.assertThat(retrievedEntity.defaultValue).isEqualTo("not default")

        retrievedEntity.testCode = JpaTestCode.FAIL
        modelIdTestRepository.save(retrievedEntity)

        val reRetrievedEntity = modelIdTestRepository.findById(multiId).get()
        Assertions.assertThat(reRetrievedEntity.defaultValue).isEqualTo("not default")
    }
}