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

    invokeWithTimeMillis(
        name = "Find shortest path in graph by BFS",
        input = mapOf(
            0 to listOf(7, 9, 11),
            1 to listOf(8, 10),
            2 to listOf(3, 12),
            3 to listOf(2, 4),
            4 to listOf(3),
            5 to listOf(6),
            6 to listOf(5, 7),
            7 to listOf(0, 3, 6, 11),
            8 to listOf(1, 9, 12),
            9 to listOf(0, 8, 10),
            10 to listOf(1, 9),
            11 to listOf(0, 7),
            12 to listOf(2, 8)
        ),
        expectedValue = listOf(0, 9, 8, 12),
        operation = { input, _ -> bfs(input, 0, 12) }
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