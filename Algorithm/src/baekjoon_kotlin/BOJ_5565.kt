package baekjoon_kotlin

import kotlin.math.abs

fun main() {
    var total = readLine()!!.toInt()

    for (i in 2 .. 10) {
        val price = readLine()!!.toInt()
        total -= price
    }

    println(abs(total))
}