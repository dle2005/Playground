package com.example.spring_mvc_1.basic.request

import com.example.spring_mvc_1.basic.HelloData
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.util.StreamUtils
import java.nio.charset.StandardCharsets

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = ["/request-body-json"])
class RequestBodyRequestServlet: HttpServlet() {

    private val objectMapper = ObjectMapper()

    override fun service(req: HttpServletRequest?, res: HttpServletResponse?) {
        val inputStream = req?.inputStream
        val messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8)

        println("messageBody = ${messageBody}")

        val helloData = objectMapper.readValue(messageBody, HelloData::class.java)

        println("helloData.username = ${helloData.username}")
        println("helloData.age = ${helloData.age}")

        res?.writer?.write("ok")
    }
}