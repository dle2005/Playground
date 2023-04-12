package baekjoon_kotlin

fun main() {
    val n = readLine()!!.toInt()
    var sum = 0

    for (idx in 1..n) {
        sum += readLine()!!.toInt()
    }

    println(sum - n + 1)
}