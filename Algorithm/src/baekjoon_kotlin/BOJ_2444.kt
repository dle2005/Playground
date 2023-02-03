package baekjoon_kotlin

fun main() {
    val n = readln().toInt()

    val sb = StringBuilder()
    for (i in 1 until n * 2) {
        if (i <= n) {
            sb.append(addSpace(n - i))
            sb.append(addStar(i))
        } else {
            sb.append(addSpace(i - n))
            sb.append(addStar(n * 2 - i))
        }
        sb.append("\n")
    }

    println(sb)
}

fun addStar(n: Int): String {
    val sb = StringBuilder()
    for (i in 0 until n - 1)
        sb.append("**")

    return sb.append("*").toString()
}

fun addSpace(n: Int): String {
    val sb = StringBuilder()
    for (i in 0 until n)
        sb.append(" ")

    return sb.toString()
}