import 'package:collection/collection.dart';

List<int> insertSort(List<int> input) {
  input.forEachIndexed((i, value) {
    int minIndex = i;

    // Scan all the elements back
    while (minIndex > 0 && value < input[minIndex - 1]) {
      input[minIndex] = input[minIndex - 1];
      minIndex -= 1;
    }

    input[minIndex] = value;
  });

  return input;
}