package baekjoon_kotlin

fun main() {
    var max = 0
    var idx = 0

    for (i in 1 .. 5) {
        val sum = readLine()!!.split(" ").sumOf { it.toInt() }

        if (sum > max) {
            max = sum
            idx = i
        }
    }

    println("${idx} ${max}")
}