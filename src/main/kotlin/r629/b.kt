package r629.b

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
        val n = readLong()
        val k = readLong()

        var t = 0L
        var p = 1L

        while (t + p < k) {
            t += p
            p++
        }

        val d = k - t

        val sb = StringBuilder()
        for (i in 0 until n) {
            sb.append(when {
                i == n - d -> "b"
                i == n - p - 1 -> "b"
                else -> "a"
            })
        }

        println(sb.toString())
    }
}
