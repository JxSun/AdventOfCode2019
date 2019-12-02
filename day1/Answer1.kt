import java.io.File

private const val INPUT_FILE = "input/input1"

fun main(args: Array<String>) {
    var sum = 0
    File(INPUT_FILE)
        .useLines { it.toList() }
        .forEach { mass ->
            sum += calculateTotalFuel(mass.toInt())
        }

    println("Sum of the fuel requirements: $sum")
}

/**
 * Answer for part2:
 * Calculates the initial fuel and all of the added fuels for the given [mass].
 */
fun calculateTotalFuel(mass: Int): Int {
    var totalFuel = 0
    var fuel = calculateFuel(mass)
    while (fuel > 0) {
        totalFuel += fuel
        fuel = calculateFuel(fuel)
    }
    return totalFuel
}

/**
 * Answer for part1.
 * Calculates fuel for the given [mass].
 */
fun calculateFuel(mass: Int): Int = mass / 3 - 2
