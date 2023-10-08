import algorithms.sort.bubbleSort
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    println("Bubble sort")
    val list = listOf(0, 20, 0, -1, 3, 55)
    println("Unsorted list $list")
    var result: List<Int>
    val time = measureTimeMillis {
        result = bubbleSort(list)
    }
    println("Sorted list $result")
    println("In time: $time millis")
    assert(result == listOf(-1, 0, 0, 3, 20, 55))
}
