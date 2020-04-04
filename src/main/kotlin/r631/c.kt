package r631.c

import java.io.PrintWriter
import java.util.*
import kotlin.math.max

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
    val n = readInt()
    val queries = IntArray(readInt()) { readInt() }

    if (queries.mapIndexed { index, query -> index + query > n }.any { it }) {
        println(-1)
        return@output
    }

    val suf = LongArray(queries.size + 1) { 0 }
    (queries.lastIndex downTo 0).forEach { index -> suf[index] = suf[index + 1] + queries[index] }

    if (suf[0] < n) {
        println(-1)
        return@output
    }

    queries.forEachIndexed { index, _ ->
        print("${max(index + 1L, n - suf[index] + 1)} ")
    }
}
