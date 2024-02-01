package src.baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())

    val sb = StringBuilder()
    repeat(n / 4) { sb.append("long ") }

    println(sb.append("int"))
}