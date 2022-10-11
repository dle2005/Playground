package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    var hour = Integer.parseInt(st.nextToken())
    var min = Integer.parseInt(st.nextToken())

    min += Integer.parseInt(br.readLine())
    if (min >= 60) hour += min / 60

    println("${hour%24} ${min%60}")
}
