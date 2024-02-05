package src.baekjoon_kotlin

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) {idx -> idx + 1}

    repeat(m) {
        val (i, j) = readln().split(" ").map { it.toInt() - 1 }
        arr.reverse(i, j + 1)
    }

    printBucket(arr)
}

private fun printBucket(arr: Array<Int>) {
    val sb = StringBuilder()
    arr.forEach { sb.append(it).append(" ") }

    println(sb)
}