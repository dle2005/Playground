package com.example.spring_basic.member

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class MemberServiceTest {

    private val memberService = MemberServiceImpl()

    @Test
    fun join() {
        // given
        val member = Member(1, "A", Grade.VIP)

        // when
        memberService.join(member)
        val findMember = memberService.findMember(1)

        // then
        Assertions.assertThat(member).isEqualTo(findMember)
    }
}