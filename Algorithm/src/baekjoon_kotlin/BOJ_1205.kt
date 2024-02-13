package src.baekjoon_kotlin

fun main() {
    val (n, newScore, p) = readln().split(" ").map { it.toInt() }
    val scores = if (n != 0) readln().split(" ").map { it.toInt() } else emptyList()

    println(findRank(n, newScore, p, scores))
}

fun findRank(n: Int, newScore: Int, p: Int, scores: List<Int>): Int {
    if (isNewScoreUnable(n, newScore, p, scores)) return -1

    var rank = 1
    scores.forEach { if (it > newScore) rank++ }

    return rank
}

fun isNewScoreUnable(n: Int, newScore: Int, p: Int, scores: List<Int>): Boolean {
    return n == p && scores[n - 1] >= newScore
}