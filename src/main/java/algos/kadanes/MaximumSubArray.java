package main.java.algos.kadanes;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum
 * Example 1:
 * <p>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 * <p>
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 * <p>
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */
public class MaximumSubArray {

    public static void main(String[] args) {

/*
 int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
System.out.println(maxSubArray(arr));*/

        //Negative
        int[] arr = {-2, -1, -3, -4, -1, -2, -1, -5, -4};
        System.out.println(maxSubArrayWithAllNegative(arr));
    }

    public static int maxSubArrayWithAllNegative(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > currentSum) {
                maxSum = Math.max(nums[i], maxSum);
            } else {
                currentSum = currentSum + nums[i];
                maxSum = Math.max(currentSum, maxSum);
            }
        }
        return maxSum;
    }

    public static int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currentSum = currentSum + nums[i];
            maxSum = Math.max(currentSum, maxSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
