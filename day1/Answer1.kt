import java.io.File

private const val INPUT_FILE = "input/input1"

fun main(args: Array<String>) {
    var sum = 0
    File(INPUT_FILE)
        .useLines { it.toList() }
        .forEach { mass ->
            sum += calculateFuel(mass.toInt())
        }

    println("Sum of the fuel requirements: $sum")
}

fun calculateFuel(mass: Int): Int = mass / 3 - 2

