package main.java.algos;

import java.util.*;

public class Temp {
    public static void main(String[] args) {
//        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams1("aababcaab", 2,3));

    }



    public static int findAnagrams1(String s, int maxLetters,int minSize) {
        int ns = s.length();
        Map<Character, Integer> sCount = new HashMap();

        int count=0;
        int tempSize=0;

        // The sliding window on the string s
        for (int i = 0; i < ns; ++i) {
            // Add one more letter
            // on the right side of the window
            char ch = s.charAt(i);
            if (sCount.containsKey(ch)) {
                sCount.put(ch, sCount.get(ch) + 1);
            } else {
                sCount.put(ch, 1);
            }
            tempSize=tempSize+1;
            // Remove one letter
            // from the left side of the window
            if (i >= minSize) {
                ch = s.charAt(i - minSize);
                if (sCount.get(ch) == 1) {
                    sCount.remove(ch);
                } else {
                    sCount.put(ch, sCount.get(ch) - 1);
                }
            }
            // Compare hashmap in the sliding window
            // with the reference hashmap
            if (sCount.size()==maxLetters && (tempSize==minSize)) {
                count++;

            }
        }
        return count;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int ns = s.length(), np = p.length();
        if (ns < np) return new ArrayList();

        Map<Character, Integer> pCount = new HashMap();
        Map<Character, Integer> sCount = new HashMap();

        // Build a reference hashmap using string p
        for (char ch : p.toCharArray()) {
            if (pCount.containsKey(ch)) {
                pCount.put(ch, pCount.get(ch) + 1);
            } else {
                pCount.put(ch, 1);
            }
        }

        List<Integer> output = new ArrayList();

        // The sliding window on the string s
        for (int i = 0; i < ns; ++i) {
            // Add one more letter
            // on the right side of the window
            char ch = s.charAt(i);
            if (sCount.containsKey(ch)) {
                sCount.put(ch, sCount.get(ch) + 1);
            } else {
                sCount.put(ch, 1);
            }

            // Remove one letter
            // from the left side of the window
            if (i >= np) {
                ch = s.charAt(i - np);
                if (sCount.get(ch) == 1) {
                    sCount.remove(ch);
                } else {
                    sCount.put(ch, sCount.get(ch) - 1);
                }
            }

            // Compare hashmap in the sliding window
            // with the reference hashmap
            if (pCount.equals(sCount)) {
                output.add(i - np + 1);
            }
        }
        return output;
    }

}
