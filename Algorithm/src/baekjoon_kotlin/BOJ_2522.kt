package baekjoon_kotlin

fun main() {
    val n = readln().toInt()

    val sb = StringBuilder()
    for (idx in 1 until 2 * n) {
        val starCnt = if (idx <= n) idx else 2 * n - idx
        val spaceCnt = n - starCnt

        for (space in 1..spaceCnt) {
            sb.append(" ")
        }
        for (star in 1..starCnt) {
            sb.append("*")
        }
        sb.append("\n")
    }

    println(sb)
}