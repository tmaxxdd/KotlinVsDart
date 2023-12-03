import 'dart:collection';

List<int> bfs(Map<int, List<int>> graph, int first, int last) {
  final paths = _solve(graph, first);

  return _reconstructPaths(paths, first, last);
}

List<int> _solve(Map<int, List<int>> graph, int first) {
  final result = List<int>.generate(graph.length, (_) => -1);
  final queue = DoubleLinkedQueue<int>();
  final visited = [];

  queue.addFirst(first);
  visited.add(first);

  while (queue.isNotEmpty) {
    // Remove node from queue and add it's neighbours
    final node = queue.removeLast();
    graph[node]?.forEach((neighbour) {
      if (!visited.contains(neighbour)) {
        queue.addFirst(neighbour);
        visited.add(neighbour);
        result[neighbour] = node;
      }
      ;
    });
  }
  ;
  return result;
}

List<int> _reconstructPaths(List<int> paths, int first, int last) {
  var result = <int>[];
  var current = last;

  while (current != first) {
    result.add(current);
    current = paths[current];
  }

  result.add(first);
  result = result.reversed.toList();

  return result;
}
