package baekjoon_kotlin

fun main() {
    val input = readln().split(" ").stream().mapToInt { it.toInt() }.toArray()

    val sortedArray = input.sorted()

    val sb = StringBuilder()
    sortedArray.forEach{ sb.append(it).append(" ")}

    println(sb)
}