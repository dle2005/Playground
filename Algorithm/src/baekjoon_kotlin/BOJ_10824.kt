package baekjoon_kotlin

fun main() {
    val (a, b, c, d) = readLine()!!.split(" ")

    val first = (a + b).toLong()
    val second = (c + d).toLong()

    println("${first + second}")
}