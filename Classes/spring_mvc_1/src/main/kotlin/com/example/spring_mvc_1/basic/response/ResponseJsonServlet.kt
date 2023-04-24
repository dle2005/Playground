package com.example.spring_mvc_1.basic.response

import com.example.spring_mvc_1.basic.HelloData
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "responseJsonServlet", urlPatterns = ["/response-json"])
class ResponseJsonServlet : HttpServlet() {
    private val objectMapper = ObjectMapper()

    override fun service(req: HttpServletRequest?, res: HttpServletResponse) {
        // Content-Type: application/json
        res.contentType = "application/json"
        res.characterEncoding = "utf-8"

        val helloData = HelloData("kim", 20)

        // {"username":"kim", "age":20}
        val result = objectMapper.writeValueAsString(helloData)
        res.writer.write(result)
    }

}