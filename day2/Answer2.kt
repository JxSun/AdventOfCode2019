import java.io.File

private const val INPUT_FILE = "input/input2"

private const val ADD = 1
private const val MULTIPLY = 2
private const val FINISH = 99

fun main(args: Array<String>) {
    val codes = loadInput(INPUT_FILE)
        .also {
            preprocess(it)
        }

    calculation@ for (i in codes.indices step 4) {
        when (codes[i]) {
            ADD -> codes[codes[i + 3]] = codes[codes[i + 1]] + codes[codes[i + 2]]
            MULTIPLY -> codes[codes[i + 3]] = codes[codes[i + 1]] * codes[codes[i + 2]]
            FINISH -> break@calculation
        }
    }

    println("Position 0: ${codes[0]}")
}

fun loadInput(filePath: String): MutableList<Int> =
    File(filePath)
        .readText()
        .split(",")
        .map { it.toInt() }
        .toMutableList()

fun preprocess(codes: MutableList<Int>) {
    codes[1] = 12
    codes[2] = 2
}
