package com.example.spring.jpa.mappedsuperclass

import com.example.spring.jpa.mappedsuperclass.TestEntity
import com.example.spring.jpa.mappedsuperclass.TestRepository
import jakarta.persistence.EntityManager
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class MappedSuperClassTest @Autowired constructor(
    private val testEntityManager: TestEntityManager,
    private val testRepository: TestRepository,
) {

    private lateinit var entityManager: EntityManager

    @BeforeEach
    fun init() {
        entityManager = testEntityManager.entityManager
    }

    @Test
    fun mappedSuperClassTest() {
        val testEntity = TestEntity()
        val savedEntity = testRepository.save(testEntity)

        entityManager.flush()
        entityManager.clear()


        testEntity.str = "str"
        testRepository.save(testEntity)

        val updatedEntity = testRepository.findById(savedEntity.id).get()

        println("savedEntity updateAt : ${savedEntity.updatedAt}")
        println("updatedEntity updateAt : ${updatedEntity.updatedAt}")
    }
}

