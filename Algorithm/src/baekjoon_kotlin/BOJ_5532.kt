package baekjoon_kotlin

import kotlin.math.ceil

fun main() {
    val l = readLine()!!.toInt()
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()
    val d = readLine()!!.toInt()

    var max: Double = (a.toDouble() / c.toDouble())
        .coerceAtLeast(b.toDouble() / d.toDouble())
    max = ceil(max)

    print(l - max.toInt())
}