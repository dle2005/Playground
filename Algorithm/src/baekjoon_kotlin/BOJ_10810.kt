package src.baekjoon_kotlin

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(n + 1)

    repeat(m) {
        insertBall(arr)
    }

    val sb = StringBuilder()
    for (idx in 1..n) {
        sb.append(arr[idx]).append(" ")
    }
    println(sb)
}

private fun insertBall(arr: IntArray) {
    val (i, j, k) = readln().split(" ").map { it.toInt() }

    for (idx in i..j) {
        arr[idx] = k
    }
}