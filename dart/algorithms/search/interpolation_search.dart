int interpolationSearch(
  List<int> input,
  int expectedValue,
) {
  var low = 0;
  var middle = -1;
  var high = input.length - 1;

  while (low <= high) {
    middle = _interpolateValue(low, high, input, expectedValue);

    if (input[middle] == expectedValue) {
      return middle;
    }

    if (input[middle] < expectedValue) {
      low = middle + 1;
    } else {
      high = middle - 1;
    }
  }

  return middle;
}

// https://www.gstatic.com/education/formulas2/553212783/en/interpolation_formula.svg
// x1 + ( (x2 - x1) / (y2 - y1) * (VALUE - y1) )
int _interpolateValue(int low, int high, List<int> data, int value) {
  final width = high - low;
  final difference = data[high] - data[low];
  final ratio = width / difference.toDouble();
  final valueDistance = value - data[low];

  return (low + ratio * valueDistance).toInt();
}
