package baekjoon_kotlin

import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()

    while (true) {
        val st = StringTokenizer(readln())
        val first = st.nextToken().toInt()
        val second = st.nextToken().toInt()

        if (first == 0 && second == 0) break

        if (second % first == 0) {
            sb.append("factor").append("\n")
        } else if (first % second == 0) {
            sb.append("multiple").append("\n")
        } else {
            sb.append("neither").append("\n")
        }
    }

    println(sb)
}