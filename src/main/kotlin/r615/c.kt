package r615.c

import java.io.PrintWriter
import java.lang.StringBuilder
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
        var n = readLong()

        val fact = mutableListOf<Long>()
        val limit = sqrt(n.toDouble()).toLong()
        for (i in 2..limit) {
            while (n % i == 0L) fact.add(i).also { n /= i }
        }
        if (n > 1) fact.add(n)

        if (fact.size < 3) {
            println("NO")
            return@repeat
        }

        val ans = mutableListOf<Long>()
        ans.add(fact.first()).also { fact.removeAt(0) }
        ans.add(fact.first()).also { fact.removeAt(0) }
        ans.add(1)

        for (f in fact) {
            if (ans[0] == ans[1]) ans[1] *= f
            else ans[2] *= f
        }

        if (ans.distinct().size < 3 || ans.last() == 1L) {
            println("NO")
        } else {
            println("YES")
            println(ans.joinToString(separator = " "))
        }
    }
}
