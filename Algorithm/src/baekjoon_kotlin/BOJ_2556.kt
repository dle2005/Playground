package baekjoon_kotlin

fun main() {
    var max = 0
    var r = 1
    var c = 1

    for (i in 1..9) {
        val line = readLine()!!.split(" ").map { it.toInt() }

        for (j in 0 until 9) {
            if (line[j] > max) {
                max = line[j]
                r = i
                c = j + 1
            }
        }
    }

    println(max)
    println("${r} ${c}")
}