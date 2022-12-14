package lec12

fun main() {
    println(KotlinSingleton.a)
    KotlinSingleton.a += 10
    println(KotlinSingleton.a)
}

object KotlinSingleton {
    var a: Int = 0
}