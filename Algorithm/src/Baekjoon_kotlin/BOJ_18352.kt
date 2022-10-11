package Baekjoon_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = Integer.parseInt(st.nextToken())
    val m = Integer.parseInt(st.nextToken())
    val k = Integer.parseInt(st.nextToken())
    val x = Integer.parseInt(st.nextToken())

    var list = Array(n + 1) { ArrayList<Int>() }
    var visit = BooleanArray(n + 1) { false }

    for (i in 1..m) {
        st = StringTokenizer(br.readLine())
        val a = Integer.parseInt(st.nextToken())
        val b = Integer.parseInt(st.nextToken())
        list[a].add(b)
    }

    var queue = LinkedList<Node>()
    queue.add(Node(x, 0))
    visit[x] = true

    var answer = PriorityQueue<Int>()

    while (queue.isNotEmpty()) {
        var cur = queue.poll()

        if (cur.cnt == k) {
            answer.add(cur.pos)
            continue
        }

        for (next in list[cur.pos]) {
            if (visit[next]) continue

            visit[next] = true;
            queue.add(Node(next, cur.cnt + 1))
        }
    }

    if (answer.isEmpty()) println(-1)
    else println(answer.sorted().joinToString("\n"))
}

class Node(val pos: Int, val cnt: Int)
