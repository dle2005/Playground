package com.example.spring_jpa_basic.autoincrement

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
internal class AutoIncrementTest @Autowired constructor(
    private val testRepository: TestRepository,
) {
    @Test
    fun AutoIncrement기본값설정해도에러없음() {
        val entity = TestEntity()
        val savedEntity = testRepository.saveAndFlush(entity)

        assertThat(savedEntity.id).isNotEqualTo(0)
    }
}