package baekjoon_kotlin

import java.util.StringTokenizer

fun main() {
    val x = readln().toInt()
    val n = readln().toInt()

    var sum = 0
    for (i in 0 until n) {
        val st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        sum += a * b
    }

    println(if (sum == x) "Yes" else "No")
}