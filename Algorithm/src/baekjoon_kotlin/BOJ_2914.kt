package baekjoon_kotlin

fun main() {
    val input = readln().split(" ")
    val a = input[0].toInt()
    val i = input[1].toInt()

    println(a * (i - 1) + 1)
}