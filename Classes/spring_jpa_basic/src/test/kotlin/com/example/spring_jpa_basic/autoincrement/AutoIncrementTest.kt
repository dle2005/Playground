package com.example.spring_jpa_basic.autoincrement

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
internal class AutoIncrementTest @Autowired constructor(
    private val testRepository: TestRepository,
    private val testEntityManager: TestEntityManager,
) {
    @Test
    fun AutoIncrement기본값설정해도에러없음() {
        val entity = TestEntity()
        val savedEntity = testRepository.saveAndFlush(entity)

        assertThat(savedEntity.id).isNotEqualTo(0)
    }

    @Test
    fun entityInformation_isNew_기본값검증() {
        val entity1 = TestEntity()
        val savedEntity1 = testRepository.saveAndFlush(entity1)

        testEntityManager.clear()

        val entity2 = TestEntity()
        val savedEntity2 = testRepository.saveAndFlush(entity2)

        assertThat(savedEntity1.id).isEqualTo(1)
        assertThat(savedEntity2.id).isEqualTo(2)
    }
}