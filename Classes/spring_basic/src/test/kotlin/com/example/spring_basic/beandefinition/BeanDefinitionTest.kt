package com.example.spring_basic.beandefinition

import com.example.spring_basic.AppConfig
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class BeanDefinitionTest {

    private val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    fun findApplicationBean() {
        val beanDefinitionNames = applicationContext.beanDefinitionNames
        for (beanDefinitionName in beanDefinitionNames) {
            val beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName)

            if (beanDefinition.role == BeanDefinition.ROLE_APPLICATION) {
                println("beanDefinitionName = ${beanDefinitionName} beanDefinition = ${beanDefinition}")
            }
        }
    }

}