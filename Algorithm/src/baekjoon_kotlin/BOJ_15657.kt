package baekjoon_kotlin

fun main() {
    val (n, m) = readLine()!!.split(" ").map(String::toInt)
    val inputArr = readLine()!!.split(" ").map(String::toInt).sorted()

    generateSequences(inputArr, m, mutableListOf(), 0)
        .joinToString("\n") { it.joinToString(" ") }
        .let(::println)
}

fun generateSequences(inputArr: List<Int>, m: Int, sequence: MutableList<Int>, startIndex: Int): List<List<Int>> {
    if (sequence.size == m) return listOf(sequence.toList())

    val result = mutableListOf<List<Int>>()

    for (i in startIndex until inputArr.size) {
        sequence.add(inputArr[i])
        result.addAll(generateSequences(inputArr, m, sequence, i))
        sequence.removeAt(sequence.lastIndex)
    }

    return result
}