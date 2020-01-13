package kotlinHeroes3.e

import java.io.PrintWriter
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

fun main() = output {
    repeat(readInt()) {
        val g = Array(readInt()) { mutableListOf<Int>() }
        val k = readInt()

        repeat(g.size - 1) {
            val u = readInt()
            val v = readInt()

            g[u - 1].add(v - 1)
            g[v - 1].add(u - 1)
        }

        var t = 0
        val qN = LinkedList<Int>().also { it += 0 }
        val qP = LinkedList<Int>().also { it += -1 }
        val ans = mutableListOf<Int>()
        val d = IntArray(g.size) { 0 }

        while (qN.isNotEmpty() && t != k) {
            val n = qN.pop()
            val p = qP.pop()

            ans += n
            t += 1

            if (p != -1) {
                d[p] += 1
                d[n] += 1
                if (d[p] == 2) t -= 1
            }

            g[n].filter { it != p }.forEach {
                qN += it
                qP += n
            }
        }

        if (t == k) {
            println("Yes")
            println(ans.size)
            ans.map { "${it + 1} " }.forEach(::print).also { println() }
        } else {
            println("No")
        }
    }
}
