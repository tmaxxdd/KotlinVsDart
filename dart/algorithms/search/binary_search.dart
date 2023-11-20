import 'dart:math';

final random = Random.secure();

int binarySearch(List<int> input, int expectedValue) {
  var minIndex = 0;
  var maxIndex = input.length;
  var foundIndex = random.nextInt(maxIndex - minIndex) + minIndex;
  var guessedValue = input[foundIndex];

  while (guessedValue != expectedValue) {
    if (expectedValue > guessedValue)
      minIndex = foundIndex;

    if (expectedValue < guessedValue)
      maxIndex = foundIndex;

    foundIndex = random.nextInt(maxIndex - minIndex) + minIndex;
    guessedValue = input[foundIndex];
  }

  return foundIndex;
}