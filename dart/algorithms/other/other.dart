import 'second_biggest_number.dart';

final int MIN_VALUE = double.minPositive.toInt();
final int MAX_VALUE = double.maxFinite.toInt();

void main() {
  invokeWithStopwatch(
    name: '2nd biggest number search',
    input: [55, -1, MAX_VALUE, 0, 4, 0, 22, MAX_VALUE],
    expectedValue: 55,
    operation: (input, _) => secondBiggestNumber(input, repeated: false),
  );
}

void invokeWithStopwatch({
  required String name,
  required List<int> input,
  required int expectedValue,
  required int Function(List<int> input, int expectedValue) operation,
}) {
  print(name);
  print('Input list: $input');
  Stopwatch stopwatch = Stopwatch()..start();
  final result = operation(input, expectedValue);
  stopwatch.stop();
  print('Result: $result');
  print('In time: ${stopwatch.elapsedMilliseconds} millis');
  assert(result == expectedValue);
  print('');
}
