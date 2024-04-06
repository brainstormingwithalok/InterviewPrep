package main.java.algos.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.



Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
 */
public class DecodeString {
    public static void main(String[] args) {
        //Expected:"aaabcbc"
        System.out.println(decodeString("3[a]2[bc]"));
    }

    public static String decodeString(String s) {
        //3[a]2[bc]

        Stack<Character> stack = new Stack<>();
        char[] sArray = s.toCharArray();
        for (int i = 0; i < sArray.length; i++) {

            if (sArray[i] == ']') {
                List<Character> decodeString = new ArrayList<>();
                while (stack.peek() != '[') {
                    decodeString.add(stack.pop());
                }

                //In case of '[' pop
                stack.pop();
                //Get the number
                int base = 1;
                int k = 0;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base = base * 10;
                }
                //push the data in the stack
                while (k != 0) {
                    for (int j = decodeString.size() - 1; j >= 0; j--) {
                        stack.push(decodeString.get(j));
                    }
                    k--;
                }

            } else {
                stack.push(sArray[i]);
            }
        }

        //Get the stack data in char array
        char[] result = new char[stack.size()];
        int index = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return new String(result);

    }
}
