package algorithms.sort

import kotlin.math.ceil

fun mergeSort(input: MutableList<Int>): MutableList<Int> {
    if (input.size < 2) return input

    val half = ceil(input.size / 2.0).toInt()
    val chunked: List<MutableList<Int>> =
        input
        .chunked(half)
        .map { it as MutableList<Int> }

    val left = mergeSort(chunked[0])
    val right = mergeSort(chunked[1])

    return merge(left, right)
}

private fun merge(
    left: MutableList<Int>,
    right: MutableList<Int>,
): MutableList<Int> {
    if (left.isEmpty()) return left
    if (right.isEmpty()) return right

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

        if (leftIndex == left.size) {
            result.addAll(
                right.subList(
                    fromIndex = rightIndex,
                    toIndex = right.size,
                )
            )

            break
        }

        if (rightIndex == right.size) {
            result.addAll(
                left.subList(
                    fromIndex = leftIndex,
                    toIndex = left.size,
                )
            )

            break
        }
    }

    return result
}
