List<int> kmp(String text, String pattern) {
  var posInText = 0;
  var posInPattern = 0;

  final textLen = text.length;
  final patternLen = pattern.length;

  final matches = <int>[];
  final longestPrefix = computeLongestPrefix(pattern);

  while (posInText < textLen) {
    // The text matches pattern
    if (text[posInText] == pattern[posInPattern]) {
      posInPattern++;
      posInText++;

      // Last match is found, add it to the results
      if (posInPattern == patternLen) {
        matches.add(posInText - posInPattern);
        posInPattern = longestPrefix[posInPattern - 1];
      }
    }

    if (posInText < textLen && text[posInText] != pattern[posInPattern]) {
      if (posInPattern != 0) {
        // Try to find a match earlier in the prefix
        posInPattern = longestPrefix[posInPattern - 1];
      } else {
        // No match, move to the next
        posInText++;
      }
    }
  }

  return matches;
}

/**
 * Compute longest prefix which is also a suffix for pattern (repeated in itself)
 * For example, for pattern "AABAACAABAA"
 * the longest prefix is: [0, 1, 0, 1, 2, 0, 1, 2, 3, 4, 5].
 *
 * This means the found and repeated is A, then AA, then AAB, etc.
 */
List<int> computeLongestPrefix(String pattern) {
  final patternLen = pattern.length;
  // Fill with 0 by default
  final output = List.generate(patternLen, (_) => 0);

  var len = 0;
  var i = 1;

  // No longer than pattern
  while (i < patternLen) {
    // Last match
    if (pattern[i] == pattern[len]) {
      len++;
      output[i] = len;
      i++;
    } else {
      if (len != 0) {
        len = output[len - 1];
      } else {
        output[i] = len;
        i++;
      }
    }
  }

  return output;
}
