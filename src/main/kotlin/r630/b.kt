package r630.b

import java.io.PrintWriter
import java.util.*
import kotlin.math.sqrt

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
        val numbers = IntArray(readInt()) { readInt() }
        val colors = IntArray(numbers.size) { 0 }

        val map = mutableMapOf<Int, Int>()

        numbers.forEachIndexed { index, number ->
            for (i in 2..sqrt(number.toDouble()).toInt()) {
                if (number % i == 0) {
                    if (!map.containsKey(i)) map[i] = map.size + 1
                    colors[index] = map[i]!!
                    break
                }
            }
        }

        println(colors.distinct().size)
        println(colors.joinToString(separator = " "))
    }
}
