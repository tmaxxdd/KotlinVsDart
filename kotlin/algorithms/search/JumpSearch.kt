package algorithms.search

import kotlin.math.sqrt

fun jumpSearch(input: List<Int>, expectedValue: Int): Int {
    val step = sqrt(input.size.toDouble()).toInt()
    var foundIndex = 0
    var previousIndex = 0

    while (input[foundIndex] < expectedValue) {
        previousIndex = foundIndex
        foundIndex += step
    }

    for (i in previousIndex..foundIndex) {
        if (input[i] == expectedValue) {
            foundIndex = i
            break
        }
    }

    return foundIndex
}