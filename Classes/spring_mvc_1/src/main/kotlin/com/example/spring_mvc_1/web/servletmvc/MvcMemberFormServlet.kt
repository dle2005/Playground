package com.example.spring_mvc_1.web.servletmvc

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = ["/servlet-mvc/member/new-form"])
class MvcMemberFormServlet : HttpServlet() {

    override fun service(req: HttpServletRequest, res: HttpServletResponse) {
        val viewPath = "WEB-INF/view/new-form.jsp"
        val dispatcher = req.getRequestDispatcher(viewPath)
        dispatcher.forward(req, res)
    }
}