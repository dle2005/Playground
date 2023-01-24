package baekjoon_kotlin

import kotlin.math.pow

fun main() {
    var sum = 0

    readln().split(" ").forEach {
        sum += it.toDouble().pow(2).toInt()
    }

    println(sum % 10)
}