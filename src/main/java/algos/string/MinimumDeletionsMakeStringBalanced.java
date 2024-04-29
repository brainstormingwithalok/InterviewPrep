package main.java.algos.string;

/*
You are given a string s consisting only of characters 'a' and 'b'​​​​.

You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.

Return the minimum number of deletions needed to make s balanced.



Example 1:

Input: s = "aababbab"
Output: 2
Explanation: You can either:
Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or
Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").
Example 2:

Input: s = "bbaaaaabb"
Output: 2
Explanation: The only solution is to delete the first two characters.
 */
public class MinimumDeletionsMakeStringBalanced {
    public static void main(String[] args) {
        System.out.println(minimumDeletions("bbaaaaabb"));
    }

    public static int minimumDeletions(String s) {
        /*
       // Solution1 using stack
        int del=0;
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()=='b' && c=='a'){
                del++;
                stack.pop();
            } else{
                stack.push(c);
            }
        }
        return del;
        */
        int res=0,c=0;
        for (int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='b') c+=1;
            if(c>0 && ch=='a')
            {
                c-=1;
                res+=1;
            }
        }
        return res;
    }
}
