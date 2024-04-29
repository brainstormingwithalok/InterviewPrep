package main.java.algos.dp;

import java.util.Arrays;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.



Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobber {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1};
//        System.out.println(rob(nums));
        System.out.println(bottomToTop(nums));
    }

    //Top to down approach, using recursion and memoization
    public static int rob(int[] nums) {
        //For the memoization
        int[] mem = new int[101];
        //Fill the array with -1
        Arrays.fill(mem, 0, mem.length, -1);
        return rob(nums, 0, mem);
    }


    public static int rob(int[] nums, int iIndex, int[] mem) {
        //Base case if i crossess the out of bound
        if (iIndex >= nums.length) {
            return 0;
        }
        //Check if computed value present
        if (mem[iIndex] != -1) {
            return mem[iIndex];
        }
        //In case first element participate
        int theaft = nums[iIndex] + rob(nums, iIndex + 2, mem);
        //In case first element doesn't participate
        int noTheaft = rob(nums, iIndex + 1, mem);
        mem[iIndex] = Math.max(theaft, noTheaft);
        return mem[iIndex];
    }

    //Bottom to top approach
    public static int bottomToTop(int[] nums) {
        //Start with the array of size equals to nums+1
        int[] table = new int[nums.length+1];
        table[0]=0;
        table[1]=nums[0];
        for(int i=2;i<=nums.length;i++){
            table[i]= Math.max(table[i-1],nums[i-1]+table[i-2]);
        }
        return table[nums.length];
    }

}
