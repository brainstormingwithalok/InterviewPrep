package main.java.algos.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

public class FindAllAnagramsOfString {
    public static void main(String[] args) {
        System.out.println(findAnagrams("eidbaooo","ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        Map<Character,Integer> sMap=new HashMap<>();
        Map<Character,Integer> pMap=new HashMap<>();
        int pLen=p.length();
        List<Integer> result=new ArrayList<>();
        for(char c: p.toCharArray()){
            if(pMap.containsKey(c)){
                pMap.put(c,pMap.get(c)+1);
            }
            else{
                pMap.put(c,1);
            }
        }
        for(int i=0;i<s.length();i++){
            if(sMap.containsKey(s.charAt(i))){
                sMap.put(s.charAt(i),sMap.get(s.charAt(i))+1);
            }
            else{
                sMap.put(s.charAt(i),1);
            }
            //This is to clean the map since size greater than the p
            if(i>=p.length()){
                char t=s.charAt(i-pLen);
                //Remove only if value of the key ==1, else decrement
                if(sMap.get(t)==1){
                    sMap.remove(t);
                }
                else{
                    sMap.put(t,sMap.get(t)-1);
                }
            }

            //If map matches with the pMap then it's the string anagram
            if(pMap.equals(sMap)){
                result.add(i-pLen+1);
            }
        }
        return result;

    }
}
