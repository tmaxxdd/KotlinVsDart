package algorithms.search

fun interpolationSearch(input: List<Int>, expectedValue: Int): Int {
    var low = 0
    var middle = -1
    var high = input.lastIndex

    while (low <= high) {
        middle = interpolateValue(low, high, input, expectedValue)

        if (input[middle] == expectedValue) {
            return middle
        }

        if (input[middle] < expectedValue) {
            low = middle + 1
        } else {
            high = middle - 1
        }
    }

    return middle
}

// https://www.gstatic.com/education/formulas2/553212783/en/interpolation_formula.svg
// x1 + ( (x2 - x1) / (y2 - y1) * (VALUE - y1) )
private fun interpolateValue(low: Int, high: Int, data: List<Int>, value: Int): Int {
    val width = high - low
    val difference = data[high] - data[low]
    val ratio: Double = width / difference.toDouble()
    val valueDistance = value - data[low]

    return (low + ratio * valueDistance).toInt()
}