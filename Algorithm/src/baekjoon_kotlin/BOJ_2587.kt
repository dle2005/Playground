package baekjoon_kotlin

fun main() {
    val arr = IntArray(5)

    for (i in 0 until 5) {
        arr[i] = readln().toInt()
    }

    val sortedArray = arr.sorted()

    println(sortedArray.sum() / 5)
    println(sortedArray[2])
}