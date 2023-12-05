import 'dart:collection';

final class EntryItem extends LinkedListEntry<EntryItem> {
  EntryItem(this.id);

  final int id;
}

bool floydsCycle(LinkedList<EntryItem> list) {
  var slowPointer = list.firstOrNull;
  var fastPointer = list.firstOrNull;

  while (
      slowPointer != null && fastPointer != null && fastPointer.next != null) {
    final next = slowPointer.next;
    slowPointer = next;
    fastPointer = next?.next;

    if (slowPointer?.id == fastPointer?.id) {
      break;
    }
  }

  if (slowPointer?.id != fastPointer?.id) {
    return false;
  }

  // reset slow pointer to head
  // and traverse again
  slowPointer = list.firstOrNull;
  while (slowPointer?.id != fastPointer?.id) {
    final next = slowPointer!.next;
    slowPointer = next;
    fastPointer = next?.next;
  }

  return slowPointer?.id == fastPointer?.id;
}
