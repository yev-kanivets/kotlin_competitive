package r631.b

import java.io.PrintWriter
import java.util.*
import kotlin.math.max
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
        val array = IntArray(readInt()) { readInt() }
        val n = array.size

        val d1 = check(array)
        val d2 = check(array.reversedArray())

        val ans = mutableListOf<Pair<Int, Int>>()
        for (i in 0 until n - 1) {
            if (d1[i] && d2[n - 2 - i]) ans += Pair(i + 1, n - i - 1)
        }

        println(ans.size)
        ans.forEach { println("${it.first} ${it.second}") }
    }
}

private fun check(array: IntArray): BooleanArray {
    val ans = BooleanArray(array.size) { false }
    val set = IntArray(array.size) { 0 }

    var maxV = -1

    array.forEachIndexed { index, value ->
        if (set[value] > 0) return ans
        set[value]++

        maxV = max(maxV, value)
        if (maxV == index + 1) ans[index] = true
    }

    return ans
}
