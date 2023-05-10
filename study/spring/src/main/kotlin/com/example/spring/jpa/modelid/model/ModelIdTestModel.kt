package com.example.spring.jpa.modelid.model

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.io.Serializable

@JsonSerialize(using = ModelIdTestModel.ModelIdTestModelSerializer::class)
@JsonDeserialize(using = ModelIdTestModel.ModelIdTestModelDeserializer::class)
data class ModelIdTestModel(
    val value: String
) : Serializable {
    class ModelIdTestModelSerializer : JsonSerializer<ModelIdTestModel>() {

        override fun serialize(modelIdTestModel: ModelIdTestModel, gen: JsonGenerator, serializers: SerializerProvider?) {
            gen.writeString(modelIdTestModel.value)
        }
    }

    class ModelIdTestModelDeserializer : JsonDeserializer<ModelIdTestModel>() {

        override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): ModelIdTestModel {
            return ModelIdTestModel(p.valueAsString)
        }
    }
}
