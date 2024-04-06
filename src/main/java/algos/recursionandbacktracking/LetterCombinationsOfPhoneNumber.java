package main.java.algos.recursionandbacktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 */
public class LetterCombinationsOfPhoneNumber {
    //private Map<Integer,String> pattern=Map.of(0,"",1,"",2,"abc",3,"def",4,"ghi",5,"jkl",6,"mno",7,"pqrs",8,"tuv",9,"wxyz");
    static Map<Integer, String> pattern = null;

    public static void main(String[] args) {
        //Expected:["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        pattern = new HashMap<>();
        pattern.put(0, "");
        pattern.put(1, "");
        pattern.put(2, "abc");
        pattern.put(3, "def");
        pattern.put(4, "ghi");
        pattern.put(5, "jkl");
        pattern.put(6, "mno");
        pattern.put(7, "pqrs");
        pattern.put(8, "tuv");
        pattern.put(9, "wxyz");
        if (digits.equalsIgnoreCase("")) {
            return new ArrayList<>();
        }
        return getSeq(digits);
    }

    public static List<String> getSeq(String digits) {

        if (digits.equalsIgnoreCase("")) {
            List<String> first = new ArrayList<>();
            first.add("");
            return first;
        }

        char initial = digits.charAt(0);
        String rem = digits.substring(1);
        List<String> values = getSeq(rem);
        List<String> result = new ArrayList<>();
        String initialString = pattern.get(initial - '0');

        for (int i = 0; i < initialString.length(); i++) {
            for (String value : values) {
                result.add(initialString.charAt(i) + value);
            }
        }
        return result;
    }


}
