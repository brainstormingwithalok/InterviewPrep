package main.java.algos.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String strs[] = {"flower", "flow", "flight"};
        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strs) {
        int len = Integer.MAX_VALUE;
        String prefixString = "";
        for (String s : strs) {
            if (s.length() < len) {
                prefixString = s;
                len = s.length();
            }
        }
        int mainStringLen = strs.length;
        while (len > 0 && mainStringLen > 0) {

            String temp = strs[mainStringLen - 1].substring(0, len);
            if (!temp.equalsIgnoreCase(prefixString)) {
                len--;
                prefixString = prefixString.substring(0, len);
            } else {
                mainStringLen--;
            }

        }
        return prefixString;
    }
}
