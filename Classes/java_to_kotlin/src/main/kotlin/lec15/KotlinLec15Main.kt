package lec15

import java.time.Month

fun main() {
    val array = arrayOf(100, 200)

    for (i in array.indices) {
        println("$i ${array[i]}")
    }

    array.plus(300)

    for ((idx, value) in array.withIndex()) {
        println("$idx $value")
    }

    val numbers = listOf(100, 200)  // 불변리스트
    val numbers_2 = mutableListOf(100, 200) // 가변리스트
    val emptyList = emptyList<Int>()

    println(numbers.get(0))
    println(numbers[0])

    for (number in numbers) {
        println(number)
    }

    for ((idx, value) in numbers.withIndex()) {
        println("$idx, $value")
    }

    val set = setOf(100, 200)   // 불변집합 LinkedHashSet
    val set_2 = mutableSetOf(100, 200)  // 가변집합 LinkedHashSet

    val oldMap = mutableMapOf<Int, String>() // 가변맵
    oldMap.put(1, "MONDAY")
    oldMap[2] = "TUESDAY"

    val newMap = mapOf(1 to "MONDAY", 2 to "TUESDAY") //불변맵

    for (key in oldMap.keys) {
        println(key)
        println(oldMap.get(key))
        println(oldMap[key])
    }

    for ((key, value) in oldMap.entries) {
        println("$key $value")
    }
}