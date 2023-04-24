package com.example.spring_mvc_1.basic.request

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "requestHeaderServlet", urlPatterns = ["/request-header"])
class RequestHeaderServlet : HttpServlet() {

    override fun service(req: HttpServletRequest?, res: HttpServletResponse?) {
        req?.let { printStartLine(it) }
        req?.let { printHeaders(it) }
        req?.let { printHeaderUtils(it) }
    }

    private fun printStartLine(req: HttpServletRequest) {
        println("--- REQUEST-LINE - start ---")

        println("req.method = ${req.method}") // GET
        println("req.protocol = ${req.protocol}") // HTTP/1.1
        println("req.scheme = ${req.scheme}") // http
        // http://localhost:8080/request-header
        println("req.requestURL = ${req.requestURL}")
        // /request-test
        println("req.requestURI = ${req.requestURI}")
        // username=hi
        println("req.queryString = ${req.queryString}")
        println("req.isSecure = ${req.isSecure}") // https 사용 유무
        println("--- REQUEST-LINE - end ---")
        println()
    }

    private fun printHeaders(req: HttpServletRequest) {
        println("--- Headers - start ---")

        req.headerNames.asIterator()
            .forEachRemaining { headerName -> println("$headerName: $headerName") }


        println("--- Headers - end ---")
        println()
    }

    private fun printHeaderUtils(req: HttpServletRequest) {
        println("--- Header 편의 조회 start ---")

        println("[Host 편의 조회]")
        println("request.serverName = ${req.serverName}") // Host 헤더
        println("request.serverPort = ${req.serverPort}") // Host 헤더
        println()

        println("[Accept-Language 편의 조회]")
        req.locales.asIterator().forEachRemaining { locale ->
            println("locale = $locale")
        }
        println("request.locale = ${req.locale}")
        println()

        println("[Cookie 편의 조회]")
        req.cookies?.forEach { cookie ->
            println("${cookie.name}: ${cookie.value}")
        }
        println()

        println("[Content 편의 조회]")
        println("request.contentType = ${req.contentType}")
        println("request.contentLength = ${req.contentLength}")
        println("request.characterEncoding = ${req.characterEncoding}")

        println("--- Header 편의 조회 end ---")
        println()
    }

    private fun printEtc(req: HttpServletRequest) {
        println("--- 기타 조회 start ---")

        println("[Remote 정보]")
        println("request.remoteHost = ${req.remoteHost}") //
        println("request.remoteAddr = ${req.remoteAddr}") //
        println("request.remotePort = ${req.remotePort}") //
        println()

        println("[Local 정보]")
        println("request.localName = ${req.localName}") //
        println("request.localAddr = ${req.localAddr}") //
        println("request.localPort = ${req.localPort}") //

        println("--- 기타 조회 end ---")
        println()
    }
}