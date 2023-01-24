package baekjoon_kotlin

fun main() {
    val chess = arrayOf(1, 1, 2, 2, 2, 8)

    val sb = StringBuilder()
    readln().split(" ").forEachIndexed { idx, s ->
        sb.append(chess[idx] - s.toInt()).append(" ")
    }

    println(sb)
}