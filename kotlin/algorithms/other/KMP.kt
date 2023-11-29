package algorithms.other

fun kmp(text: String, pattern: String): List<Int> {
    var posInText = 0
    var posInPattern = 0

    val textLen = text.length
    val patternLen = pattern.length

    val matches = mutableListOf<Int>()
    val lps = computeLPSArray(pattern)

    while (posInText < textLen) {
        // The text matches pattern
        if (text[posInText] == pattern[posInPattern]) {
            posInPattern++
            posInText++

            // Last match is found, add it to the results
            if (posInPattern == patternLen) {
                matches.add(posInText - posInPattern)
                posInPattern = lps[posInPattern - 1]
            }
        }

        if (posInText < textLen && text[posInText] != pattern[posInPattern]) {
            if (posInPattern != 0) {
                posInPattern = lps[posInPattern - 1]
            } else {
                posInText++
            }
        }
    }

    return matches
}

fun computeLPSArray(pattern: String): IntArray {
    val patternLen = pattern.length
    val lps = IntArray(patternLen) { 0 }

    var len = 0
    var i = 1

    while (i < patternLen) {
        if (pattern[i] == pattern[len]) {
            len++
            lps[i] = len
            i++
        } else {
            if (len != 0) {
                len = lps[len - 1]
            } else {
                lps[i] = len
                i++
            }
        }
    }

    return lps
}