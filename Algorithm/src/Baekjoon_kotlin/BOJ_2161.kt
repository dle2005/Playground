package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = Integer.parseInt(br.readLine())

    var array = LinkedList<Int>()
    for (i in 1..n) array.add(i)

    var sb = StringBuilder()

    while (true) {
        sb.append(array.poll()).append(" ")

        if (array.isEmpty()) break

        array.add(array.poll())
    }

    println(sb)
}
