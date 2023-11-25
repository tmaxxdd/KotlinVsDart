package algorithms.other

import algorithms.search.secondBiggestNumber
import kotlin.system.measureTimeMillis

fun main() {
    invokeWithTimeMillis(
        name = "2nd biggest number search",
        input =  listOf(55, -1, Int.MAX_VALUE, 0, 4, 0, 22, Int.MAX_VALUE),
        expectedValue = 55,
        operation = { input, _ -> secondBiggestNumber(input, repeated = false) }
    )
}

private fun invokeWithTimeMillis(
    name: String,
    input: List<Int>,
    expectedValue: Int,
    operation: (List<Int>, Int) -> Int,
) {
    println(name)
    println("Input list: $input")
    var result: Int
    val time = measureTimeMillis {
        result = operation(input, expectedValue)
    }

    println("Result: $result")
    println("In time: $time millis")
    assert(result == expectedValue)
    println()
}