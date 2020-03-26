package r629.e

import java.io.PrintWriter
import java.lang.StringBuilder
import java.util.*

@JvmField val INPUT = System.`in`
@JvmField val OUTPUT = System.out

@JvmField val _reader = INPUT.bufferedReader()
@JvmField var _tokenizer: StringTokenizer = StringTokenizer("")

fun read(): String {
    while (_tokenizer.hasMoreTokens().not())
        _tokenizer = StringTokenizer(_reader.readLine() ?: return "", " ")
    return _tokenizer.nextToken()
}

fun readLine(): String? = _reader.readLine()
fun readLn() = _reader.readLine()!!
fun readInt() = read().toInt()
fun readDouble() = read().toDouble()
fun readLong() = read().toLong()

@JvmField val _writer = PrintWriter(OUTPUT, false)

inline fun output(block: PrintWriter.() -> Unit) {
    _writer.apply(block).flush()
}

var t = 0
lateinit var tin: IntArray
lateinit var tout: IntArray
lateinit var dist: IntArray

fun dfs(g: List<List<Int>>, u: Int, p: Int, d: Int) {
    t++
    tin[u] = t
    dist[u] = d
    for (v in g[u]) {
        if (v == p) continue
        dfs(g, v, u, d + 1)
    }
    tout[u] = t
}

fun main() = output {
    val n = readInt()
    val m = readInt()

    val g = List<MutableList<Int>>(n) { mutableListOf() }
    tin = IntArray(n) { -1 }
    tout = IntArray(n) { -1 }
    dist = IntArray(n) { -1 }

    repeat(n - 1) {
        val u = readInt()
        val v = readInt()

        g[u - 1].add(v - 1)
        g[v - 1].add(u - 1)
    }

    dfs(g, 0, -1, 0)

    repeat(m) {
        val query = IntArray(readInt()) { readInt() - 1 }
        val farthest = query.maxBy { dist[it] }!!

        val set = mutableSetOf<Int>()
        set += 0
        set += farthest

        for (i in 0 until n) {
            if (tin[i] <= tin[farthest] && tout[i] >= tout[farthest]) {
                set += i
            }
        }

        set.toSet().forEach { set.addAll(g[it]) }

        val collection = mutableListOf<Int>()
        query.toCollection(collection)

        if (set.containsAll(collection)) println("YES") else println("NO")
    }
}
