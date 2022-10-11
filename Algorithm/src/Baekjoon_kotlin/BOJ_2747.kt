package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = Integer.parseInt(br.readLine())

    var dp = IntArray((n + 1).coerceAtLeast(3))
    dp[1] = 1
    dp[2] = 1;

    for (i in 3..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    println(dp[n])
}
