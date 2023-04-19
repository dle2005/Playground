package com.example.spring_basic.web

import com.example.spring_basic.common.MyLogger
import org.springframework.stereotype.Service

@Service
class LogDemonService(
    private val myLogger: MyLogger,
) {
    fun logic(id: String) {
        myLogger.log("service id = ${id}")
    }

}
