package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

class Student(name: String, kor: Int, eng: Int, math: Int) {
    var name = ""
    var kor = 0
    var eng = 0
    var math = 0

    init {
        this.name = name
        this.kor = kor.toInt()
        this.eng = eng.toInt()
        this.math = math.toInt()
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = Integer.parseInt(br.readLine())
    val list = mutableListOf<Student>()

    for (i in 1..n) {
        val st = StringTokenizer(br.readLine())

        val name = st.nextToken()
        val kor = Integer.parseInt(st.nextToken())
        val eng = Integer.parseInt(st.nextToken())
        val math = Integer.parseInt(st.nextToken())

        list.add(Student(name, kor, eng, math))
    }

    list.sortWith(compareBy({ -it.kor }, { it.eng }, { -it.math }, { it.name }))

    for (student in list) sb.append(student.name).append("\n")

    println(sb)
}
