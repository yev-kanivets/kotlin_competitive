package kotlinHeroes3.c

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
        val arr = IntArray(readInt()) { readInt() }
        val maxSum = arr.sumBy { if (it > 0) it else 0 }

        var switchIndex = -1
        var sum = -1

        arr.forEachIndexed { index, a ->
            val t = maxSum + if (a < 0) a else -a
            if (t in (sum + 1) until maxSum) {
                sum = t
                switchIndex = index
            }
        }

        val sb = StringBuilder()
        arr.forEachIndexed { index, a ->
            if (index == switchIndex) sb.append(if (a < 0) "1" else "0")
            else sb.append(if (a > 0) "1" else "0")
        }

        println(sum)
        println(sb.toString())
    }
}
