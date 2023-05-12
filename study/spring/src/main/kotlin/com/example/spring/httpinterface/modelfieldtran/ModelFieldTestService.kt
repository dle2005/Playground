package com.example.spring.httpinterface.modelfieldtran

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.service.annotation.PostExchange

interface ModelFieldTestService {
    @PostExchange("/model_filed_test/res")
    fun getTest(@RequestBody modelFieldTestReqDto: ModelFiledTestReqDto): String
}