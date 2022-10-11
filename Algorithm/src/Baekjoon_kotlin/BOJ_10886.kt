package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var n = Integer.parseInt(br.readLine())

    var yes = 0
    var no = 0;

    while (n-- > 0) {
        if (Integer.parseInt(br.readLine()) == 1) yes++
        else no++
    }

    if (yes > no) println("Junhee is cute!")
    else println("Junhee is not cute!")
}
