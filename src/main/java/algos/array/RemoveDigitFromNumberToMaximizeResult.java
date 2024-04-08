package main.java.algos.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
You are given a string number representing a positive integer and a character digit.

Return the resulting string after removing exactly one occurrence of digit from number such that the value of the resulting string in decimal form is maximized.
The test cases are generated such that digit occurs at least once in number.



Example 1:

Input: number = "123", digit = "3"
Output: "12"
Explanation: There is only one '3' in "123". After removing '3', the result is "12".
Example 2:

Input: number = "1231", digit = "1"
Output: "231"
Explanation: We can remove the first '1' to get "231" or remove the second '1' to get "123".
Since 231 > 123, we return "231".
Example 3:

Input: number = "551", digit = "5"
Output: "51"
Explanation: We can remove either the first or second '5' from "551".
Both result in the string "51".
 */
public class RemoveDigitFromNumberToMaximizeResult {
    public static void main(String[] args) {
        //Output: "51"
//        System.out.println(removeDigit("551", '5'));
        System.out.println(removeX("1231", '1'));
    }

    //With space complexity O(n) and time O(1)
    public static String removeDigit(String number, char digit) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                list.add(number.substring(0, i) + number.substring(i + 1));
            }
        }

        return list.stream().sorted().collect(Collectors.toList()).get(list.size() - 1);
    }

    //With Time O(n) and space O(1)
    public static String removeX(String N, char X) {
        // Stores the index of X
        // that has to be removed
        int index = -1;

        // Find leftmost occurrence of X
        // such that the digit just after X
        // is greater than X
        for (int i = 0; i < N.length() - 1; i++) {
            if (N.charAt(i) == X
                    && N.charAt(i) - '0'
                    < N.charAt(i + 1) - '0') {

                // Update index and break
                index = i;
                break;
            }
        }

        // If no occurrence of X such that
        // the digit just after X
        // is greater than X is found
        // then find last occurrence of X
        if (index == -1) {
            for (int i = N.length() - 1; i >= 0; i--) {
                if (N.charAt(i) == X) {
                    index = i;
                    break;
                }
            }
        }

        // Construct answer using all characters
        // in string N except index
        String ans = "";
        for (int i = 0; i < N.length(); i++) {
            if (i != index)
                ans = ans + N.charAt(i);
        }

        return ans;
    }
}
