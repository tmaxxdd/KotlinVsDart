import 'package:collection/collection.dart';

List<int> bubbleSort(List<int> input) {
  for (int current = 0; current < input.length - 1; current++) {
    for (int next = current + 1; next < input.length; next++) {
      // Swap 2,1 to 1,2
      if (input[current] > input[next]) {
        input.swap(next, current);
      }
    }
  }

  return input;
}
