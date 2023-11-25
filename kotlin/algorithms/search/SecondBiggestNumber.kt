package algorithms.search

fun secondBiggestNumber(input: List<Int>, repeated: Boolean = true): Int {
    if (input.size < 2) return Int.MIN_VALUE

    var biggest = Int.MIN_VALUE
    var secondBiggest = Int.MIN_VALUE

    fun isSecondBiggest(input: Int, biggest: Int, secondBiggest: Int) =
        if (!repeated)
            input != biggest && input > secondBiggest
        else
            input > secondBiggest

    for (i in 0 until input.size) {
        if (input[i] > biggest) {
            secondBiggest = biggest
            biggest = input[i]
        } else if (isSecondBiggest(input[i], biggest, secondBiggest)) {
            secondBiggest = input[i]
        }
    }

    return secondBiggest
}