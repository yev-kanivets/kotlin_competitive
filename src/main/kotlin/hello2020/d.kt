package hello2020

import java.io.File
import java.io.PrintWriter
import java.lang.Math.pow
import java.util.*
import kotlin.math.pow

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
    for (p in 1..9) {
        File("array$p.in").printWriter().use {
            val n = 10.0.pow(p.toDouble()).toInt()
            val random = Random(System.currentTimeMillis())
            it.println(n)
            for (i in 0..n) { it.println(random.nextInt()) }
        }
    }
}
