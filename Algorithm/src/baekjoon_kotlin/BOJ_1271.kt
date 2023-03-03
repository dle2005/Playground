package baekjoon_kotlin

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toBigInteger()
    val m = st.nextToken().toBigInteger()

    println(n / m)
    println(n % m)
}