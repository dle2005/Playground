package com.example.spring_basic.scan.filter

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

class ComponentFilterAppConfigTest {

    @Test
    fun filterScan() {
        val ac = AnnotationConfigApplicationContext(ComponentFilterAppConfig::class.java)

        val beanA = ac.getBean("beanA", BeanA::class.java)
        Assertions.assertThat(beanA).isNotNull
        
        // exception when get BeanB
    }

    companion object {
        @Configuration
        @ComponentScan(
            includeFilters = [
                ComponentScan.Filter(
                    type = FilterType.ANNOTATION,
                    value = [MyIncludeComponent::class]
                )
            ],
            excludeFilters = [
                ComponentScan.Filter(
                    type = FilterType.ANNOTATION,
                    value = [MyExcludeComponent::class]
                )
            ]
        )
        class ComponentFilterAppConfig
    }

}