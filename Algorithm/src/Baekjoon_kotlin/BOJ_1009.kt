package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val t = Integer.parseInt(br.readLine())

    for (i in 1..t) {
        var st = StringTokenizer(br.readLine())
        val a = Integer.parseInt(st.nextToken())
        val b = Integer.parseInt(st.nextToken())

        var c = 1;
        for (j in 1..b) c = c * a % 10;

        if (c == 0) c = 10;
        sb.append(c).append("\n")
    }

    println(sb)
}
