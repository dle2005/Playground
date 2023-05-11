package com.example.spring.jpa.modelid.enum

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

enum class JpaTestCode(
    val code: String,
    val description: String,
) {
    SUCCESS("0000", "정상"),
    FAIL("9999", "비정상")
}

@Converter(autoApply = true)
class JpaTestCodeConverter : GenericCodeConverter<JpaTestCode>(JpaTestCode::class.java)

@Converter(autoApply = true)
open class GenericCodeConverter<T : Enum<T>>(private val enumClass: Class<T>) : AttributeConverter<T, String> {
    override fun convertToDatabaseColumn(attribute: T?): String? {
        return attribute?.name
    }

    override fun convertToEntityAttribute(dbData: String?): T? {
        return dbData?.let { code ->
            enumClass.enumConstants.find { it.name == code }
        }
    }
}