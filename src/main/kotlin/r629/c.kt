package r629.c

import java.io.PrintWriter
import java.lang.StringBuilder
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
        val n = readInt()
        val s = readLine()

        val sb1 = StringBuilder("1")
        val sb2 = StringBuilder("1")

        var equal = true

        s?.substring(1)?.forEach {
            if (equal) {
                when (it) {
                    '0' -> { sb1.append('0'); sb2.append('0') }
                    '1' -> { sb1.append('0'); sb2.append('1'); equal = false }
                    '2' -> { sb1.append('1'); sb2.append('1') }
                }
            } else {
                when (it) {
                    '0' -> { sb1.append('0'); sb2.append('0') }
                    '1' -> { sb1.append('1'); sb2.append('0') }
                    '2' -> { sb1.append('2'); sb2.append('0') }
                }
            }
        }

        println(sb1.toString())
        println(sb2.toString())
    }
}
