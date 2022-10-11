package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var n = Integer.parseInt(br.readLine())

    var arr: LongArray = LongArray(5.coerceAtLeast(n + 1))
    arr[1] = 4
    arr[2] = 6
    arr[3] = 10
    arr[4] = 16

    for (i in 5..n) arr[i] = arr[i - 1] + arr[i - 2]

    println(arr[n])
}
