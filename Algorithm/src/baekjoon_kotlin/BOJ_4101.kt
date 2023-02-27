package baekjoon_kotlin

import java.util.StringTokenizer

fun main() {
    var st: StringTokenizer
    var a: Int
    var b: Int
    val sb = StringBuilder()

    while (true) {
        st = StringTokenizer(readln())
        a = st.nextToken().toInt()
        b = st.nextToken().toInt()

        if (a == 0 && b == 0) {
            break
        }

        sb.append(if (a <= b) "No" else "Yes").append("\n")
    }

    println(sb)
}