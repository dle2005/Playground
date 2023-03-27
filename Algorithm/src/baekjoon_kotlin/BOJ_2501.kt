package baekjoon_kotlin

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    var cnt = 0

    for (idx in 1..n) {
        if (n % idx == 0) cnt++

        if (cnt == k) {
            println(idx)
            return
        }
    }

    println(0)
}