package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val s = br.readLine()

    var before = '.';
    var n = 0;

    s.forEach { c ->
        run {
            n += if (c != before) 10
            else 5

            before = c;
        }
    }

    println(n)
}
