package baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val y: Int = br.readLine().toInt()

    println(y + (1998 - 2541))
}