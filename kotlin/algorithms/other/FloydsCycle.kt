package algorithms.other

import java.util.LinkedList

data class Node(val value: Int, var next: Node? = null)

fun get(list: LinkedList<Node>, index: Int): Node? =
    list.getOrNull(index)

fun floydsCycle(list: LinkedList<Node>): Boolean {
    var slowIndex = 0
    var fastIndex = 0

    if (list.isEmpty()) return false

    while (get(list, slowIndex) != null
        && get(list, fastIndex) != null
        && get(list, fastIndex)?.next != null
    ) {
        val next = get(list, slowIndex)!!.next!!.value
        slowIndex = next
        fastIndex = get(list, next)!!.next!!.value

        if (get(list, slowIndex) == get(list, fastIndex)) {
            break
        }
    }

    if (get(list, slowIndex) != get(list, fastIndex)) {
        return false
    }

    // reset slow pointer to head
    // and traverse again
    slowIndex = 0
    while (get(list, slowIndex) != get(list, fastIndex)) {
        slowIndex++
        slowIndex++
    }

    return slowIndex == fastIndex;
}