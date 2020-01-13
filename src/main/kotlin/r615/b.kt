package r615.b

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

const val N = 1001

data class Package(val x: Int, val y: Int)

fun main() = output {
    repeat(readInt()) {
        val n = readInt()
        val packages = Array(n) { Package(readInt(), readInt()) }

        val ans = StringBuilder()

        var curY = 0
        var visited = 0

        for (i in 0 until N) {
            if (i != 0) ans.append("R")
            val columnPackages = packages.filter { it.x == i }.takeIf { it.isNotEmpty() } ?: continue

            val minPackage = columnPackages.minBy { it.y }!!.y
            val maxPackage = columnPackages.maxBy { it.y }!!.y

            if (minPackage < curY) {
                println("NO")
                return@repeat
            }

            repeat(maxPackage - curY) { ans.append("U") }
            curY = maxPackage
            visited += columnPackages.size

            if (visited == n) {
                println("YES")
                println(ans.toString())
                return@repeat
            }
        }

        if (visited == n) {
            println("YES")
            println(ans.toString())
            return@repeat
        } else {
            println("NO")
        }
    }
}
