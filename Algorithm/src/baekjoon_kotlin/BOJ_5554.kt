package baekjoon_kotlin

fun main() {
    var total = 0

    for (idx in 1..4) {
        total += readLine()!!.toInt()
    }

    println(total / 60)
    println(total % 60)
}