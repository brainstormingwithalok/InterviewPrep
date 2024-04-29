package main.java.algos.dp;

/*
https://leetcode.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int[][] mem=new int[text1.length()+1][text2.length()+1];
        for(int i=mem.length-2;i>=0;i--){
            for(int j=mem[0].length-2;j>=0;j--){
                char c1=text1.charAt(i);
                char c2=text2.charAt(j);
                if(c1==c2){
                    mem[i][j]=1+mem[i+1][j+1];
                }
                else{
                    mem[i][j]=Math.max(mem[i+1][j],mem[i][j+1]);
                }

            }

        }

        return mem[0][0];
    }
}
