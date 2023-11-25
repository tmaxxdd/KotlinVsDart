import 'other.dart';

int secondBiggestNumber(List<int> input, {bool repeated = true}) {
  if (input.length < 2) return MIN_VALUE;

  var biggest = MIN_VALUE;
  var secondBiggest = MIN_VALUE;

  bool _isSecondBiggest(int input, int biggest, int secondBiggest) => !repeated
      ? input != biggest && input > secondBiggest
      : input > secondBiggest;

  for (var i = 0; i < input.length - 1; i++) {
    if (input[i] > biggest) {
      secondBiggest = biggest;
      biggest = input[i];
    } else if (_isSecondBiggest(input[i], biggest, secondBiggest)) {
      secondBiggest = input[i];
    }
  }

  return secondBiggest;
}
