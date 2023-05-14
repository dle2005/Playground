package com.example.spring_jpa_basic.hellojpa

import com.example.spring_jpa_basic.SpringJpaBasicApplication
import jakarta.persistence.*
import org.springframework.boot.SpringApplication

fun main() {
    val context = SpringApplication.run(SpringJpaBasicApplication::class.java)
    val emf = context.getBean(EntityManagerFactory::class.java)
    val em = emf.createEntityManager()
    val tx = em.transaction

    tx.begin()

    try {
        val member = Member("HelloA")
        em.persist(member)

        tx.commit()
    } catch (e: Exception) {
        tx.rollback()
    } finally {
        em.clear()
    }
    emf.close()
}

@Entity
data class Member(
    val name: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,
    /**
     * 기본값을 null이 아닌 다른 값으로 설정 시,
     * persist 호출 시 이미 id 값이 있는 것으로 간주하여,
     * 이미 DB에 저장된 것으로 판단하여 오류가 발생
     */
)