package baekjoon_kotlin

fun main() {
    val n = readln().toInt()

    for (i in (1 until n)) {
        var sum = i
        var t = i

        while (t != 0) {
            sum += t % 10
            t /= 10
        }

        if (sum == n) {
            println(i)

            return
        }
    }

    println(0)
}