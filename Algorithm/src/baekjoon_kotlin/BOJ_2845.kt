package baekjoon_kotlin

fun main() {
    val (l, p) = readLine()!!.split(" ").map { it.toInt() }
    val people = readLine()!!.split(" ").map { it.toInt() }

    val estimate = l * p

    val sb = StringBuilder()
    for (person in people) {
        sb.append(person - estimate).append(" ")
    }

    println(sb)
}