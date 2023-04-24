package com.example.spring_mvc_1.basic.response

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "responseHtmlServlet", urlPatterns = ["/response-html"])
class ResponseHtmlServlet: HttpServlet() {

    override fun service(req: HttpServletRequest?, res: HttpServletResponse) {
        res.contentType = "text/html"
        res.characterEncoding = "utf-8"

        val writer = res.writer
        writer.println("<html>")
        writer.println("<body>")
        writer.println("    <div>안녕?</div>")
        writer.println("</body>")
        writer.println("</html>")
    }
}