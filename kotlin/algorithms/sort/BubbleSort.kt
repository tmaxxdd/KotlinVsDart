package algorithms.sort

import java.util.Collections
fun bubbleSort(input: List<Int>): List<Int> {
    for (current in 0 until input.size - 1) {
        for (next in current + 1 until input.size) {
            // Swap 2,1 to 1,2
            if (input[current] > input[next]) {
                Collections.swap(input, current, next)
            }
        }
    }
    return input
}