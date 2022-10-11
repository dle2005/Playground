package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var n = Integer.parseInt(br.readLine())
    var f = Integer.parseInt(br.readLine())

    n = (n / 100) * 100

    while (true) {
        if (n % f == 0) break
        else n++
    }

    val s = n.toString()
    println(s.substring(s.length - 2))
}
