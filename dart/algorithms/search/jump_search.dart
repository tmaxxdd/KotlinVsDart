import 'dart:math';

int binarySearch(List<int> input, int expectedValue) {
  final step = sqrt(input.length).toInt();
  var foundIndex = 0;
  var previousIndex = 0;

  while (input[foundIndex] < expectedValue) {
    previousIndex = foundIndex;
    foundIndex += step;
  }

  for (int i = previousIndex; i < foundIndex; i++) {
    if (input[i] == expectedValue) {
      foundIndex = i;
      break;
    }
  }

  return foundIndex;
}