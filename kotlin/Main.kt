import algorithms.sort.bubbleSort
import algorithms.sort.insertionSort
import kotlin.system.measureTimeMillis

val input: List<Int> get() = listOf(0, 20, 0, -1, 3, 55)
val expected: List<Int> get() = listOf(-1, 0, 0, 3, 20, 55)

fun main() {
    sortWithTimeMillis(
        name = "Bubble sort",
        input = input,
        expected = expected,
    ) { bubbleSort(it) }

    sortWithTimeMillis(
        name = "Insertion sort",
        input = input,
        expected = expected,
    ) { insertionSort(it.toMutableList()) }
}

fun sortWithTimeMillis(
    name: String,
    input: List<Int>,
    expected: List<Int>,
    operation: (List<Int>) -> List<Int>,
) {
    println(name)
    println("Unsorted list $input")
    var result: List<Int>
    val time = measureTimeMillis {
        result = operation(input)
    }
    println("Sorted list $result")
    println("In time: $time millis")
    assert(result == expected)
    println()
}
