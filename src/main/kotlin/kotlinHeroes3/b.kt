package kotlinHeroes3.b

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
        val arr = Array(readInt()) { Pair(readInt(), readInt()) }
        var answer = -1
        arr.forEach { (l, r) ->
            if (arr.count { l >= it.first && l <= it.second } == 1) {
                answer = l; return@forEach
            }
            if (l - 1 > 0 && arr.count { l - 1 >= it.first && l - 1 <= it.second } == 1) {
                answer = l - 1; return@forEach
            }
            if (arr.count { l + 1 >= it.first && l + 1 <= it.second } == 1) {
                answer = l + 1; return@forEach
            }
            if (arr.count { r >= it.first && r <= it.second } == 1) {
                answer = r; return@forEach
            }
            if (r - 1 > 0 && arr.count { r - 1 >= it.first && r - 1 <= it.second } == 1) {
                answer = r - 1; return@forEach
            }
            if (arr.count { r + 1 >= it.first && r + 1 <= it.second } == 1) {
                answer = r + 1; return@forEach
            }
        }
        println(answer)
    }
}
