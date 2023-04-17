package com.example.spring_basic

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    excludeFilters = [
        ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            value = [Configuration::class]
        )
    ]
)
class AutoAppConfig {

}