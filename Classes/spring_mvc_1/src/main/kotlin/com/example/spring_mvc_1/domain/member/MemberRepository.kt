package com.example.spring_mvc_1.domain.member

class MemberRepository private constructor(){
    companion object {
        val store = HashMap<Long, Member>()
        var sequence = 0L

        private val instance = MemberRepository()

        fun getInstance(): MemberRepository {
            return instance
        }
    }

    fun save(member: Member): Member {
        member.id = ++sequence
        store[member.id] = member
        return member
    }

    fun findById(id: Long): Member {
        return store[id]!!
    }

    fun findAll(): List<Member> {
        return ArrayList(store.values)
    }

    fun clearStore() {
        store.clear()
    }

}