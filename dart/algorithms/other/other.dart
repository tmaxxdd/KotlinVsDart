import 'kmp.dart';
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

  invokeWithStopwatch(
    name: 'Find pattern in text by KMP',
    input: 'AABAACAADAABAABA',
    expectedValue: [0, 9, 12],
    operation: (input, _) => kmp(input, 'AAB'),
  );
}

void invokeWithStopwatch<I, O>({
  required String name,
  required I input,
  required O expectedValue,
  required O Function(I input, O expectedValue) operation,
}) {
  print(name);
  print('Input list: $input');
  Stopwatch stopwatch = Stopwatch()..start();
  final result = operation(input, expectedValue);
  stopwatch.stop();
  print('Result: $result');
  print('In time: ${stopwatch.elapsedMilliseconds} millis');
  if (expectedValue is List<int>) {
    final resultList = result as List;
    final expectedList = expectedValue as List;
    assert(resultList.length == expectedList.length);
    for (int i = 0; i < result.length; i++) {
      assert(resultList[i] == expectedList[i]);
    }
  } else {
    assert(result == expectedValue);
  }
  print('');
}
