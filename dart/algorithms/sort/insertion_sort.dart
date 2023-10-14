List<int> insertSort(List<int> input) {
  for (int i = 0; i < input.length; i++) {

    final temp = input[i];
    int minIndex = i;

    while(minIndex > 0 && temp < input[minIndex - 1]) {
      input[minIndex] = input[minIndex - 1];
      minIndex -= 1;
    }

    input[minIndex] = temp;
  }

  return input;
}