package baekjoon_kotlin

fun main() {
    val nums: HashSet<Int> = hashSetOf()
    for (i in 1..30) {
        nums.add(i)
    }

    for (i in 0 until 28) {
        nums.remove(readln().toInt())
    }

    val rest: List<Int> = nums.toList().sorted()
    println(rest[0])
    println(rest[1])
}