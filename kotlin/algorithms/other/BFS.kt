package algorithms.other

fun bfs(graph: Map<Int, List<Int>>, first: Int, last: Int): List<Int> {
    val paths = solve(graph, first)

    return reconstructPaths(paths, first, last)
}

private fun solve(graph: Map<Int, List<Int>>, first: Int): List<Int> {
    val result = MutableList(graph.size) { -1 }
    val queue = ArrayDeque<Int>()
    val visited = mutableSetOf<Int>()

    queue.addFirst(first)
    visited.add(first)

    while (queue.isNotEmpty()) {
        // Remove node from queue and add it's neighbours
        val node = queue.removeLast()
        graph[node]?.forEach { neighbour ->
            if (!visited.contains(neighbour)) {
                queue.addFirst(neighbour)
                visited.add(neighbour)
                result[neighbour] = node
            }
        }
    }

    return result
}

private fun reconstructPaths(paths: List<Int>, first: Int, last: Int): List<Int> {
    val result = mutableListOf<Int>()
    var current = last

    while (current != first) {
        result.add(current)
        current = paths[current]
    }

    result.add(first)
    result.reverse()

    return result
}