package com.example.spring_mvc_1.basic

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "helloServlet", urlPatterns = ["/hello"])
class HelloServlet : HttpServlet() {

    override fun service(req: HttpServletRequest?, res: HttpServletResponse?) {
        println("HelloServlet.service")
        println("request = ${req}")
        println("response = ${res}")

        val username = req?.getParameter("username")
        println("username = ${username}")

        res?.contentType = "text/plain"
        res?.characterEncoding = "utf-8"
        res?.writer?.write("hello ${username}")
    }

}