package com.example.spring_jpa_basic.dirtychecking

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
internal class DirtyCheckingTest @Autowired constructor(
    private val testRepository: DirtyCheckingTestRepository,
    private val testEntityManager: TestEntityManager,
) {

    @Test
    fun 변경이후자동저장_1차캐시에서조회() {
        val entity = DirtyCheckingTestEntity("origin")
        val id = testRepository.saveAndFlush(entity).id!!

        testEntityManager.clear()

        val savedEntity = testRepository.findById(id).get()
        savedEntity.value = "changed"

        testEntityManager.flush()

        val changedEntity = testRepository.findById(id).get()
        assertThat(changedEntity.value).isEqualTo("changed")
    }

    @Test
    fun 변경이후자동저장_1차캐시초기화() {
        val entity = DirtyCheckingTestEntity("origin")
        val id = testRepository.saveAndFlush(entity).id!!

        testEntityManager.clear()

        val savedEntity = testRepository.findById(id).get()
        savedEntity.value = "changed"

        testEntityManager.flush()
        testEntityManager.clear()

        val changedEntity = testRepository.findById(id).get()
        assertThat(changedEntity.value).isEqualTo("changed")
    }
}