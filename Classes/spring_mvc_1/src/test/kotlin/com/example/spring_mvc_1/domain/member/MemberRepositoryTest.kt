package com.example.spring_mvc_1.domain.member

import com.example.spring_mvc_1.domain.member.Member
import com.example.spring_mvc_1.domain.member.MemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

internal class MemberRepositoryTest {

    private val memberRepository = MemberRepository.getInstance()

    @AfterEach
    fun afterEach() {
        memberRepository.clearStore()
    }

    @Test
    internal fun save() {
        val member = Member("hello", 20)

        val savedMember = memberRepository.save(member)

        val findMember = memberRepository.findById(savedMember.id)

        assertThat(findMember.id).isEqualTo(1L)
        assertThat(findMember).isEqualTo(savedMember)
    }
}