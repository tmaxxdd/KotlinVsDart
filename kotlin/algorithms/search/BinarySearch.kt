package algorithms.search

import kotlin.random.Random

fun binarySearch(input: List<Int>, expectedValue: Int): Int {
    var minIndex = 0
    var maxIndex = input.size
    var foundIndex = Random.nextInt(minIndex, maxIndex)
    var guessedValue = input[foundIndex]

    while (guessedValue != expectedValue) {
        if (expectedValue > guessedValue)
            minIndex = foundIndex

        if (expectedValue < guessedValue)
            maxIndex = foundIndex

        foundIndex = Random.nextInt(minIndex, maxIndex)
        guessedValue = input[foundIndex]
    }

    return foundIndex
}