package baekjoon_kotlin

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val arr = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        st = StringTokenizer(readln())
        for (j in 0 until m) {
            arr[i][j] = st.nextToken().toInt()
        }
    }

    for (i in 0 until n) {
        st = StringTokenizer(readln())
        for (j in 0 until m) {
            arr[i][j] += st.nextToken().toInt()
        }
    }

    val sb = StringBuilder()
    for (i in 0 until n) {
        for (j in 0 until m) {
            sb.append(arr[i][j]).append(" ")
        }
        sb.append("\n")
    }

    println(sb)
}