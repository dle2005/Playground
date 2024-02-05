package src.baekjoon_kotlin

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { idx -> idx + 1}

    repeat(m) {
        val (i, j) = readln().split(" ").map { it.toInt() - 1 }
        switchBall(arr, i, j)
    }

    printBucket(arr)
}

private fun printBucket(arr: Array<Int>) {
    val sb = StringBuilder()
    arr.forEach { sb.append(it).append(" ") }

    println(sb)
}

private fun switchBall(arr: Array<Int>, i: Int, j: Int) {
    val num1 = arr[i]
    val num2 = arr[j]

    arr[i] = num2
    arr[j] = num1
}