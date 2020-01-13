package r615.d

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

data class Pair<F : Comparable<F>, S : Comparable<S>>(
    val first: F,
    val second: S
) : Comparable<Pair<F, S>> {

    override fun compareTo(other: Pair<F, S>) = when {
        first < other.first -> -1
        first > other.first -> 1
        second < other.second -> -1
        second > other.second -> 1
        else -> 0
    }
}

fun main() = output {
    val q = readInt()
    val x = readInt()

    val mods = IntArray(x) { 0 }
    val set = TreeSet<Pair<Int, Int>>()

    mods.forEachIndexed { index, mod -> set += Pair(mod, index) }

    repeat(q) {
        val cur = readInt()

        set.remove(Pair(mods[cur % x], cur % x))
        mods[cur % x]++
        set.add(Pair(mods[cur % x], cur % x))

        println(set.first().first * x + set.first().second)
    }
}
