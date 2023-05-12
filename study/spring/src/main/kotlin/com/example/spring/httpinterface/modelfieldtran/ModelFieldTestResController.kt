package com.example.spring.httpinterface.modelfieldtran

import com.example.spring.common.logger
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/model_filed_test/res")
class ModelFieldTestResController {

    val log = logger()

    @PostMapping
    fun getTest(@RequestBody modelFiledTestResDto: ModelFiledTestResDto): String {
        log.info("resController model ${modelFiledTestResDto.model?.str}")
        return "OK"
    }
}