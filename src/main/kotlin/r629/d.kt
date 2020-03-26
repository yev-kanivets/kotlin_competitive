package r629.d

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
        val figures = IntArray(readInt()) { readInt() }
        val colors = IntArray(figures.size) { -1 }

        var t = 0
        val streaks = mutableListOf<Int>()

        figures.forEachIndexed { index, figure ->
            if (index == 0) {
                colors[index] = 0
                t = 1
                return@forEachIndexed
            }

            if (figure == figures[index - 1]) {
                colors[index] = colors[index - 1]
                t++
            } else {
                colors[index] = (colors[index - 1] + 1) % 2
                streaks.add(t)
                t = 1
            }
        }

        streaks.add(t)

        if (figures.last() != figures.first() && colors.first() == colors.last()) {
            if ((streaks.max() ?: 0) == 1) colors[colors.lastIndex] = 2
            else {
                var streakPrefix = 0
                for (streak in streaks) {
                    if (streak == 1) streakPrefix++ else break
                }

                colors[streakPrefix + 1] = (colors[streakPrefix + 1] + 1) % 2
                for (i in (streakPrefix + 2) until colors.size) {
                    colors[i] = (colors[i] + 1) % 2
                }
            }
        }

        println(colors.distinct().size)
        colors.forEach { print("${it + 1} ") }
        println()
    }
}
