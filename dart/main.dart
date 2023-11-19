import 'package:collection/collection.dart';

import 'algorithms/sort/bubble_sort.dart';
import 'algorithms/sort/insertion_sort.dart';

get input => [0, 20, 0, -1, 3, 55];
get expected => [-1, 0, 0, 3, 20, 55];

void main() {
  sortWithStopwatch(
    name: 'Bubble sort',
    input: input,
    expected: expected,
    operation: (input) => bubbleSort(input),
  );

  sortWithStopwatch(
    name: 'Insertion sort',
    input: input,
    expected: expected,
    operation: (input) => insertSort(input),
  );

  sortWithStopwatch(
    name: 'Merge sort',
    input: input,
    expected: expected,
    operation: (input) => mergeSort(input),
  );
}

void sortWithStopwatch({
  required String name,
  required List<int> input,
  required List<int> expected,
  required List<int> Function(List<int> input) operation,
}) {
  print(name);
  print('Unsorted list $input');
  Stopwatch stopwatch = Stopwatch()..start();
  final result = operation(input);
  stopwatch.stop();
  print('Sorted list $result');
  print('In time: ${stopwatch.elapsedMilliseconds} millis');
  assert(result.equals(expected));
  print('');
}
