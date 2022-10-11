package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    var a = st.nextToken()
    var b = st.nextToken()

    var result:Long = 0

    a.forEach { n ->
        b.forEach { m ->
            result += (n - '0') * (m - '0') }
    }

    println(result)
}
