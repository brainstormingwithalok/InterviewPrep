package main.java.algos.dp;

import java.util.Arrays;

/*
Top to Down
https://www.youtube.com/watch?v=5AxMZBirNKo
//Bottom to top
https://www.youtube.com/watch?v=Sobml7FprQ0
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.



Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobber2 {
    public static void main(String[] args) {
        int nums[] = {2,3,2};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        //For the memoization
        int[] mem = new int[101];
        return rob(nums,mem);

    }

    public static int rob(int[] nums,int[] mem) {
        int n=nums.length;
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        //Fill the array with -1
        Arrays.fill(mem, 0, mem.length, -1);
        //If first taken
        int firstIndex=rob(nums,mem,0,n-2);
        //Fill the array with -1
        Arrays.fill(mem, 0, mem.length, -1);
        //If second taken
        int secondIndex=rob(nums,mem,1,n-1);

        return Math.max(firstIndex,secondIndex);

    }



    public static int rob(int[] nums,int[] mem,int index,int size) {
        //Base case if i crossess the out of bound
        if (index > size) {
            return 0;
        }
        //Check if computed value present
        if (mem[index] != -1) {
            return mem[index];
        }
        //In case first element participate
        int theaft = nums[index] + rob(nums, mem,index + 2,size);
        //In case first element doesn't participate
        int noTheaft = rob(nums, mem,index + 1,size);
        mem[index] = Math.max(theaft, noTheaft);
        return mem[index];
    }

}
