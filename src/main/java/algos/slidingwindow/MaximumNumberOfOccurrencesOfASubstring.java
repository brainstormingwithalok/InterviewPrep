package main.java.algos.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;


/**
 *
 * Given a string s, return the maximum number of occurrences of any substring under the following rules:
 *
 * The number of unique characters in the substring must be less than or equal to maxLetters.
 * The substring size must be between minSize and maxSize inclusive.
 *
 *
 * Example 1:
 *
 * Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
 * Output: 2
 * Explanation: Substring "aab" has 2 occurrences in the original string.
 * It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
 * Example 2:
 *
 * Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
 * Output: 2
 * Explanation: Substring "aaa" occur 2 times in the string. It can overlap.

 *
 */

//Note : maxSize no role in this question
public class MaximumNumberOfOccurrencesOfASubstring {
    public static void main(String[] args) {
        System.out.println(maxFreq("aababcaab", 2, 3, 4));

    }

    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if (s == null || s.length() == 0 || maxLetters == 0) return 0;
        HashMap<String, Integer> hm = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length() - minSize + 1; i++) {
            String cur = s.substring(i, i + minSize);
            if (isValid(cur, maxLetters)) {
                hm.put(cur, hm.getOrDefault(cur, 0) + 1);
                max = Math.max(max, hm.get(cur));
            }
        }
        return max;
    }

    static boolean isValid(String cur, int maxLetters) {
        // length of cur  = minSize and makes this method run O(1)
        HashSet<Character> hs = new HashSet<>();
        for (char c : cur.toCharArray()) hs.add(c);
        return hs.size() <= maxLetters;
    }
}
