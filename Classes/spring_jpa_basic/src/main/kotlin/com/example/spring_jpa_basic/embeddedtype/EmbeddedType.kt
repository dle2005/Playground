package com.example.spring_jpa_basic.embeddedtype

import com.example.spring_jpa_basic.SpringJpaBasicApplication
import com.example.spring_jpa_basic.hellojpa.Member
import jakarta.persistence.*
import org.springframework.boot.SpringApplication
import org.springframework.data.jpa.repository.JpaRepository

@Embeddable
data class EmbeddedTypeModel(
    var value: String,
)

@Entity
data class EmbeddedTypeEntity(
    @Embedded
    val embeddedValue: EmbeddedTypeModel,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
)

interface EmbeddedTypeRepository : JpaRepository<EmbeddedTypeEntity, Long>

fun main() {
    val context = SpringApplication.run(SpringJpaBasicApplication::class.java)
    val emf = context.getBean(EntityManagerFactory::class.java)
    val em = emf.createEntityManager()
    val tx = em.transaction

    tx.begin()

    try {
        val entity = EmbeddedTypeEntity(EmbeddedTypeModel("Test"))
        em.persist(entity)

        tx.commit()
    } catch (e: Exception) {
        tx.rollback()
    } finally {
        em.clear()
    }
    emf.close()
}
