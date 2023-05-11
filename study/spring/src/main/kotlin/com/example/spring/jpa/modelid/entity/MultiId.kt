package com.example.spring.jpa.modelid.entity

import com.example.spring.jpa.modelid.model.ModelIdTestModel
import java.io.Serializable

class MultiId(
    val testModel: ModelIdTestModel? = null,
    val multiId: String? = null,
) : Serializable