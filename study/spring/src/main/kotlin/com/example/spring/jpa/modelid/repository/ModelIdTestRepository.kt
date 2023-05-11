package com.example.spring.jpa.modelid.repository

import com.example.spring.jpa.modelid.entity.ModelIdTestEntity
import com.example.spring.jpa.modelid.entity.MultiId
import com.example.spring.jpa.modelid.model.ModelIdTestModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ModelIdTestRepository : JpaRepository<ModelIdTestEntity, MultiId> {
}