package algorithms.sort

fun insertionSort(input: MutableList<Int>): List<Int> {
    input.forEachIndexed { i, value ->
        var minIndex = i

        // Scan all the elements back
        while(minIndex > 0 && value < input[minIndex - 1]) {
            input[minIndex] = input[minIndex - 1]
            minIndex -= 1
        }

        input[minIndex] = value
    }

    return input
}