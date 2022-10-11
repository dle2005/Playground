package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val a = st.nextToken().toCharArray()
    val b = st.nextToken().toCharArray()

    var cnt = 0;


    if (a.size == b.size) {
        for (i in a.indices) {
            if (a[i] != b[i]) break
            else if (a[i] == '8') cnt++
        }
    }

    println(cnt)
}
