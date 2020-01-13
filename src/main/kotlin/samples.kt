import java.io.File
import java.io.PrintWriter
import java.util.*
import java.util.Collections.max
import java.util.Collections.min

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

/*fun main() = output {
    var sum = 0
    repeat(readInt()) { sum += readInt() }
    println(sum)
}*/

fun main() = output {
    val random = Random()

    val a = List(1_000_000) { random.nextInt() }

    val averageOf3MinValues = a.sorted().subList(0, 3).average()
    val averageOf5MaxValues = a.sortedDescending().subList(0, 5).average()

    val distinctCount = a.distinct().size

    val positiveValues = a.filter { it > 0 }
    val nonPositiveValues = a.subtract(positiveValues)

    val product = a.reduce { accumulated, value -> accumulated * value }
}
