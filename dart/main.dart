
import 'package:collection/collection.dart';

import 'algorithms/sort/bubble_sort.dart';

void main() {

  print("Bubble sort");
  final list = [0, 20, 0, -1, 3, 55];
  print('Unsorted list $list');
  final result = bubbleSort(list);
  print('Sorted list $result');
  assert(result.equals([-1, 0, 0, 3, 20, 55]));

}