package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = Integer.parseInt(br.readLine())

    var sb = StringBuilder()

    for (i in 1..n) {
        var st = StringTokenizer(br.readLine())

        var pq = PriorityQueue<Int>()
        while (st.hasMoreTokens()) {
            pq.add(Integer.parseInt(st.nextToken()))
            if (pq.size > 3) pq.poll()
        }

        sb.append(pq.poll()).append("\n")
    }

    println(sb)
}
