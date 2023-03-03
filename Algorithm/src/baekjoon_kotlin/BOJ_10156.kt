package baekjoon_kotlin

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val k = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val needMoney = m - k * n
    println(if (needMoney < 0) -needMoney else 0)
}