package algorithms.search

import kotlin.system.measureTimeMillis

val input: List<Int> = listOf(-1, 0, 0, 4, 22, 55, Int.MAX_VALUE, Int.MAX_VALUE)
const val expectedValue: Int = 4
const val expectedIndex: Int = 3

fun main() {
    searchWithTimeMillis(
        name = "Binary search",
        input = input,
        expectedValue = expectedValue,
        expectedIndex = expectedIndex,
        operation = { input, expectedValue -> binarySearch(input, expectedValue) }
    )

    searchWithTimeMillis(
        name = "Jump search",
        input = input,
        expectedValue = expectedValue,
        expectedIndex = expectedIndex,
        operation = { input, expectedValue -> jumpSearch(input, expectedValue) }
    )

    searchWithTimeMillis(
        name = "Interpolation search",
        input = input,
        expectedValue = expectedValue,
        expectedIndex = expectedIndex,
        operation = { input, expectedValue -> interpolationSearch(input, expectedValue) }
    )
}

private fun searchWithTimeMillis(
    name: String,
    input: List<Int>,
    expectedValue: Int,
    expectedIndex: Int,
    operation: (List<Int>, Int) -> Int,
) {
    println(name)
    println("Sorted list: $input")
    var result: Int
    val time = measureTimeMillis {
        result = operation(input, expectedValue)
    }
    println("Value $expectedValue found at index: $result")
    println("In time: $time millis")
    assert(result == expectedIndex)
    println()
}
