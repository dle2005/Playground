package baekjoon_kotlin

fun main() {
    val n = readln().toInt()

    val sb = StringBuilder()
    for (i in 0 until n) {
        for (j in 0 until i) {
            sb.append(" ")
        }
        sb.append("*")
        for (j in 0 until n - i - 1) {
            sb.append("**")
        }
        sb.append("\n")
    }

    println(sb)
}