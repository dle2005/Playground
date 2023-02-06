package baekjoon_kotlin

import kotlin.math.abs

fun main() {
    val input = readln().split(" ")
    val n = input[0].toLong()
    val m = input[1].toLong()

    println(abs(n - m))
}