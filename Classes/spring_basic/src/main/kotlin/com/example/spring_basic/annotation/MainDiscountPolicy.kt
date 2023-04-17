package com.example.spring_basic.annotation

import org.springframework.beans.factory.annotation.Qualifier
import java.lang.annotation.Inherited

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@Inherited
@MustBeDocumented
@Qualifier("mainDiscountPolicy")
annotation class MainDiscountPolicy()
