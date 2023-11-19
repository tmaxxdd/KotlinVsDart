List<int> mergingSort(List<int> input) {
  if (input.length < 2) return input;

  final left = mergingSort(input.sublist(0, input.length ~/ 2));
  final right = mergingSort(input.sublist(input.length ~/ 2));

  return _merge(left, right);
}

List<int> _merge(List<int> left, List<int> right) {
  if (left.isEmpty) return left;
  if (right.isEmpty) return right;

  final result = <int>[];
  final totalSize = left.length + right.length;
  var leftIndex = 0;
  var rightIndex = 0;

  while(result.length < totalSize) {
    if (left[leftIndex] < right[rightIndex]) {
      result.add(left[leftIndex]);
      leftIndex++;
    } else {
      result.add(right[rightIndex]);
      rightIndex++;
    }

    if (leftIndex == left.length) {
      result.addAll(right.sublist(rightIndex));

      break;
    }

    if (rightIndex == right.length) {
      result.addAll(left.sublist(leftIndex));

      break;
    }
  }

  return result;
}
