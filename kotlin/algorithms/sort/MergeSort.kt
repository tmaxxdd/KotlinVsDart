package algorithms.sort

import kotlin.math.ceil

fun mergeSort(input: MutableList<Int>): MutableList<Int> {

    fun merge(
        left: MutableList<Int>,
        right: MutableList<Int>,
    ): MutableList<Int> {
        if (left.isEmpty())
            return left

        if (right.isEmpty())
            return right

        val result = mutableListOf<Int>()
        val totalSize = left.size + right.size
        var leftIndex = 0
        var rightIndex = 0

        while (result.size < totalSize) {

            if (left[leftIndex] < right[rightIndex]) {
                result.add(left[leftIndex])
                leftIndex++
            } else {
                result.add(right[rightIndex])
                rightIndex++
            }

//            if (leftIndex == left.size or rightIndex == right.size) {
//
//                result.extend(left[leftIndex:] or right[rightIndex:])
//                break
//            }
        }

        return result
    }

    if (input.size < 2)
        return input

    val chunked: List<MutableList<Int>> = input
        .chunked(ceil(input.size / 2.0).toInt())
        .map { it as MutableList<Int> }

    val left = mergeSort(chunked[0])
    val right = mergeSort(chunked[1])

    return merge(left, right)
}
