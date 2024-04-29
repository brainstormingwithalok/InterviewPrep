package main.java.algos.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
Explanation: The only string in arr has all 26 characters.
 */
/*
Complexity -> time= 2^n (because one to choose or not ) , space o(n)
 */
public class MaxLengthOfConcatenateStrWithUniChar {
    public static void main(String[] args) {
    //["un","iq","ue"]  -> Output=4
        List<String> list= Arrays.asList("un","iq","ue");
        System.out.println(maxLength(list));
    }
    public static int maxLength(List<String> arr) {
        if(arr.size()==0){
            return 0;
        }
        //Empty list to capture the result
        List<String> allList=new ArrayList<>();
        allList.add("");
        int max=0;
        for(int i=0;i<arr.size();i++){
            List<String> rem=new ArrayList<>();
            for(String str:allList){
                if(isValid(str)){
                    String temp=str+arr.get(i);
                    if(isValid(temp)){
                        rem.add(temp);
                        max=Math.max(max,temp.length());
                    }
                }

            }
            allList.addAll(rem);
        }

        return max;

    }

    public static boolean isValid(String str){
        char[] charArray=new char[26];
        for(char c: str.toCharArray()){
            charArray[c-'a']++;
            if(charArray[c-'a']>1){
                return false;
            }
        }
        return true;
    }
}
