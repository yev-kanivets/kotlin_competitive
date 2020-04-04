package r630.a

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
        val a = readLong()
        val b = readLong()
        val c = readLong()
        val d = readLong()

        val x = readLong()
        val y = readLong()
        val x1 = readLong()
        val y1 = readLong()
        val x2 = readLong()
        val y2 = readLong()

        val h = min(a, b)
        val v = min(c, d)

        if ((x2 - x1 > 0 || (a == 0L && b == 0L))
            && (y2 - y1 > 0 || (c == 0L && d == 0L))
            && (x - (a - h) >= x1 && x + (b - h) <= x2)
            && (y - (c - v) >= y1 && y + (d - v) <= y2)
        ) println("Yes") else println("No")
    }
}
