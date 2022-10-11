package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var s = br.readLine().toLong()

    var sum: Long = 0;
    for (i in 1..s) {
        sum += i

        if (sum > s) {
            println(i - 1)
            break
        } else if (sum == s) {
            println(i)
            break
        }
    }
}
