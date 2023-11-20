import 'binary_search.dart';

final input = [
  -1,
  0,
  0,
  4,
  22,
  55,
  double.maxFinite.toInt(),
  double.maxFinite.toInt()
];
const expectedValue = 4;

const expectedIndex = 3;

void main() {
  searchWithStopwatch(
    name: 'Binary search',
    input: input,
    expectedValue: expectedValue,
    expectedIndex: expectedIndex,
    operation: (input, expectedValue) => binarySearch(input, expectedValue),
  );
}

void searchWithStopwatch({
  required String name,
  required List<int> input,
  required int expectedValue,
  required int expectedIndex,
  required int Function(List<int> input, int expectedValue) operation,
}) {
  print(name);
  print('Sorted list: $input');
  Stopwatch stopwatch = Stopwatch()..start();
  final result = operation(input, expectedValue);
  stopwatch.stop();
  print('Value $expectedValue found at index: $result');
  print('In time: ${stopwatch.elapsedMilliseconds} millis');
  assert(result == expectedIndex);
  print('');
}
