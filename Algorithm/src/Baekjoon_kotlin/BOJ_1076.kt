package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val a = br.readLine()
    val b = br.readLine()
    val c = br.readLine()

    var result:Long? = 0
    result = result?.plus(value(a) * 10)
    result = result?.plus(value(b))
    result = result?.times(times(c))

    println(result)
}

fun value(color: String): Int = when (color) {
    "black" -> 0
    "brown" -> 1
    "red" -> 2
    "orange" -> 3
    "yellow" -> 4
    "green" -> 5
    "blue" -> 6
    "violet" -> 7
    "grey" -> 8
    "white" -> 9
    else -> -1
}

fun times(color: String): Int = when (color) {
    "black" -> 1
    "brown" -> 10
    "red" -> 100
    "orange" -> 1000
    "yellow" -> 10000
    "green" -> 100000
    "blue" -> 1000000
    "violet" -> 10000000
    "grey" -> 100000000
    "white" -> 1000000000
    else -> -1
}
