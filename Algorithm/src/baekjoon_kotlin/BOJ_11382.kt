package baekjoon_kotlin

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val a = st.nextToken().toLong()
    val b = st.nextToken().toLong()
    val c = st.nextToken().toLong()

    println(a + b + c)
}