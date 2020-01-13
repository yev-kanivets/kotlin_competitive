package kotlinHeroes3.d

import java.io.PrintWriter
import java.util.*
import kotlin.math.min

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
        val n = readInt()
        var k = readLong()
        val arr = Array(n) { Pair(readLong(), it) }.sortedDescending()

        val d = Array(n) { 0L }

        for (i in 1 until n) {
            d[arr[i].second] += min(k, arr[i - 1].first + d[arr[i - 1].second] - arr[i].first - 1)
            k -= d[arr[i].second]
        }

        for (i in 0 until n) {
            d[i] += k / n
        }
        k %= n

        for (i in 0 until k.toInt()) {
            d[arr[i].second]++
        }

        d.forEach { print("$it ") }.also { println() }
    }
}

data class Pair<F : Comparable<F>, S : Comparable<S>>(
    val first: F,
    val second: S
) : Comparable<Pair<F, S>> {

    override fun compareTo(other: Pair<F, S>) = when {
        first < other.first -> -1
        first > other.first -> 1
        second < other.second -> -1
        second > other.second -> 1
        else -> 0
    }
}
