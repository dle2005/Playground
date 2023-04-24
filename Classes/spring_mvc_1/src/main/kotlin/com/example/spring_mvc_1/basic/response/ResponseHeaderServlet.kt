package com.example.spring_mvc_1.basic.response

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.io.IOException

@WebServlet(name = "responseHeaderServlet", urlPatterns = ["/response-header"])
class ResponseHeaderServlet : HttpServlet() {
    override fun service(req: HttpServletRequest?, res: HttpServletResponse?) {
        // [status-line]
        res?.status = HttpServletResponse.SC_OK

        // [response-headers]
        res?.setHeader("Content-Type", "text/plain;charset=utf-8")
        res?.setHeader("Cache-Control", "no-cache, no-store, must-revalidate")
        res?.setHeader("Pragma", "no-cache")

        res?.let { content(res) }
        res?.let { cookie(res) }
        res?.let { redirect(res) }

        val writer = res?.writer
        writer?.println("ok")
    }

    private fun content(response: HttpServletResponse) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.contentType = "text/plain"
        response.characterEncoding = "utf-8"
        //response.setContentLength(2); //(생략시 자동 생성)
    }

    private fun cookie(response: HttpServletResponse) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        // response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        val cookie = Cookie("myCookie", "good")
        cookie.maxAge = 600 //600초
        response.addCookie(cookie)
    }

    @Throws(IOException::class)
    private fun redirect(response: HttpServletResponse) {
        //Status Code 302
        //Location: /basic/hello-form.html
        //response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html")
    }
}