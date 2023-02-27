package baekjoon_kotlin

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    var a = st.nextToken().toInt()
    var b = st.nextToken().toInt()
    var c = st.nextToken().toInt()
    val d = readln().toInt()

    c += d

    b += c / 60
    c %= 60

    a += b / 60
    b %= 60

    a %= 24

    println("$a $b $c")
}