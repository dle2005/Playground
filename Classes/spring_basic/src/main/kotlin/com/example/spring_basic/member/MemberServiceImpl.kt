package com.example.spring_basic.member

class MemberServiceImpl : MemberService {

    private val memberRepository = MemoryMemberRepository()

    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findMember(memberId: Long): Member {
        return memberRepository.findById(memberId)
    }
}