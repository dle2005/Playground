package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sb = StringBuilder()

    val t = Integer.parseInt(br.readLine())
    for (i in 1..t) {
        var st = StringTokenizer(br.readLine())
        var str1 = st.nextToken().toCharArray()
        var str2 = st.nextToken().toCharArray()

        sb.append(str1).append(" & ").append(str2)

        Arrays.sort(str1)
        Arrays.sort(str2)

        val s1 = str1.joinToString("")
        val s2 = str2.joinToString("")

        if (s1.compareTo(s2) == 0)
            sb.append(" are anagrams.").append("\n")
        else sb.append(" are NOT anagrams.").append("\n")
    }

    println(sb)
}
