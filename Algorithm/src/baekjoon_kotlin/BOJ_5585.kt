package baekjoon_kotlin

fun main() {
    var n = 1000 - readln().toInt()
    var sum = 0;

    while (n != 0) {
        n -= if (500 <= n) {
            500
        } else if (100 <= n) {
            100
        } else if (50 <= n) {
            50
        } else if (10 <= n) {
            10
        } else if (5 <= n) {
            5
        } else {
            1
        }

        sum++
    }

    println(sum)
}