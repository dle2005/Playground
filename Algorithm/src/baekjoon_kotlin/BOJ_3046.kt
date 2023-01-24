package baekjoon_kotlin

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val r1 = st.nextToken().toInt()
    val s = st.nextToken().toInt()

    println(s * 2 - r1)
}