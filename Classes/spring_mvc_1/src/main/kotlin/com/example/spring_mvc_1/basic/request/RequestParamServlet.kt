package com.example.spring_mvc_1.basic.request

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "requestParamServlet", urlPatterns = ["/request-param"])
class RequestParamServlet : HttpServlet() {
    
    override fun service(req: HttpServletRequest?, res: HttpServletResponse?) {
        println("[전체 파라미터 조회] - start")

        req?.parameterNames?.asIterator()
            ?.forEachRemaining { paramName -> println("${paramName} = ${req.getParameter(paramName)}") }

        println("[전체 파라미터 조회] - end")

        println("[단일 파라미터 조회]")
        val username = req?.getParameter("username")
        val age = req?.getParameter("age")

        println("username = ${username}")
        println("age = ${age}")

        println("[이름이 같은 복수 파라미터 조회]")
        val usernames = req?.getParameterValues("username")
        usernames?.forEach { _ -> println("username = ${username}") }

        res?.writer?.write("ok")
    }
}