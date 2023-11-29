package algorithms.other

import algorithms.search.secondBiggestNumber
import kotlin.system.measureTimeMillis

fun main() {
    invokeWithTimeMillis(
        name = "2nd biggest number search",
        input = listOf(55, -1, Int.MAX_VALUE, 0, 4, 0, 22, Int.MAX_VALUE),
        expectedValue = 55,
        operation = { input, _ -> secondBiggestNumber(input, repeated = false) }
    )

    invokeWithTimeMillis(
        name = "Find pattern in text by KMP",
        input = "AABAACAADAABAABA",
        expectedValue = listOf(0, 9, 12),
        operation = { input, _ -> kmp(input, "AAB") }
    )
}

private fun <I, O> invokeWithTimeMillis(
    name: String,
    input: I,
    expectedValue: O,
    operation: (I, O) -> O,
) {
    println(name)
    println("Input list: $input")
    var result: O
    val time = measureTimeMillis {
        result = operation(input, expectedValue)
    }

    println("Result: $result")
    println("In time: $time millis")
    assert(result == expectedValue)
    println()
}