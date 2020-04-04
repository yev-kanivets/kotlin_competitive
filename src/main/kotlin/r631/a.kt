package r631.a

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
        var x = readInt()
        val a = IntArray(n) { readInt() }.toSet()

        var ans = 0

        for (i in 1..1000) {
            if (a.contains(i)) ans++
            else if (x > 0) {
                x--
                ans++
            } else break
        }

        println(ans)
    }
}
