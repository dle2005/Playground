package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.text.DecimalFormat
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sb = StringBuilder()

    var t = Integer.parseInt(br.readLine())


    for (i in 1..t) {
        var st = StringTokenizer(br.readLine())

        var n = st.nextToken().toDouble()

        while (st.hasMoreTokens()) {
            var c = st.nextToken()

            when (c) {
                "@" -> n *= 3
                "%" -> n += 5
                "#" -> n -= 7
            }
        }

        sb.append(DecimalFormat(".00").format(n)).append("\n")
    }

    println(sb)
}
