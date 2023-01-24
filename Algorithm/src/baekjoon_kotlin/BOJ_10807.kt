package baekjoon_kotlin

fun main() {
    readln()
    val input = readln().split(" ")
    val v = readln().toInt()

    var sum = 0
    input.forEach {
        if (it.toInt() == v) sum++
    }

    println(sum)
}