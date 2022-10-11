package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = Integer.parseInt(st.nextToken())
    val k = Integer.parseInt(st.nextToken())

    var arr = Array(n + 1) { Array(n + 1) { 1 } }

    for (i in 2..n) {
        for (j in 1 until i) {
            arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j]

        }
    }
    
    println(arr[n][k])
}
