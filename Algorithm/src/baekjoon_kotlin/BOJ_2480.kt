package baekjoon_kotlin

import java.util.*

fun main() {
    val st = StringTokenizer(readln())
    val dice1 = st.nextToken().toInt()
    val dice2 = st.nextToken().toInt()
    val dice3 = st.nextToken().toInt()

    when {
        dice1 == dice2 && dice2 == dice3 -> println(10000 + dice1 * 1000)
        dice1 == dice2 -> println(1000 + dice1 * 100)
        dice1 == dice3 -> println(1000 + dice1 * 100)
        dice2 == dice3 -> println(1000 + dice2 * 100)
        else -> println(maxOf(dice1, dice2, dice3) * 100)
    }
}