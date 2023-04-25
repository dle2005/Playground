package com.example.spring_mvc_1.web.servlet

import com.example.spring_mvc_1.domain.member.Member
import com.example.spring_mvc_1.domain.member.MemberRepository
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "memberSaveServlet", urlPatterns = ["/servlet/members/save"])
class MemberSaveServlet : HttpServlet() {

    private val memberRepository = MemberRepository.getInstance()

    override fun service(req: HttpServletRequest, res: HttpServletResponse) {
        println("MemberSaveServlet.service")
        val username = req.getParameter("username")
        val age = req.getParameter("age").toInt()

        val member = Member(username, age)
        memberRepository.save(member)

        res.contentType = "text/html"
        res.characterEncoding = "utf-8"

        val w = res.writer
        w.write("<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" + "</head>\n" +
                "<body>\n" +
                "성공\n" +
                "<ul>\n" +
                "    <li>id="+member.id+"</li>\n" +
                "    <li>username="+member.username+"</li>\n" +
                "    <li>age="+member.age+"</li>\n" + "</ul>\n" +
                "<a href=\"/index.html\">메인</a>\n" + "</body>\n" +
                "</html>")
    }
}