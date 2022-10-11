package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var st = StringTokenizer(br.readLine())
    var n = Integer.parseInt(st.nextToken())
    Integer.parseInt(st.nextToken())

    var map = HashMap<Int, Int>()

    st = StringTokenizer(br.readLine())
    for (i in 1..n) {
        var input = Integer.parseInt(st.nextToken())

        if (map.containsKey(input))
            map[input] = map.getValue(input) + 1
        else map[input] = 1
    }

    var list = map.toList().sortedWith(compareBy { -it.second })

    var sb = StringBuilder()

    list.forEach {
        for (i in 1..it.second) sb.append(it.first).append(" ")
    }

    println(sb)
}
