package com.example.spring.httpinterface.modelfieldtran

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.io.Serializable

@JsonSerialize(using = ModelFiledTestModel.ModelFiledTestModelSerializer::class)
@JsonDeserialize(using = ModelFiledTestModel.ModelFiledTestModelDeserializer::class)
data class ModelFiledTestModel(
    val str: String = ""
) : Serializable {

    class ModelFiledTestModelSerializer : JsonSerializer<ModelFiledTestModel>() {

        override fun serialize(modelFiledTestModel: ModelFiledTestModel, gen: JsonGenerator, serializers: SerializerProvider?) {
            gen.writeString(modelFiledTestModel.str)
        }
    }

    class ModelFiledTestModelDeserializer : JsonDeserializer<ModelFiledTestModel>() {

        override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): ModelFiledTestModel {
            return ModelFiledTestModel(p.valueAsString)
        }
    }
}
