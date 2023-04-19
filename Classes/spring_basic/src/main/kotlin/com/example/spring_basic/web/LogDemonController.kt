package com.example.spring_basic.web

import com.example.spring_basic.common.MyLogger
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class LogDemonController(
    private val logDemonService: LogDemonService,
    private val myLogger: MyLogger,
) {
    @RequestMapping("log-demo")
    @ResponseBody
    fun logDemo(request: HttpServletRequest): String {
        val requestURL = request.requestURL.toString()
        myLogger.setRequestURL(requestURL)

        myLogger.log("controller test")
        logDemonService.logic("testId")

        return "OK"
    }
}