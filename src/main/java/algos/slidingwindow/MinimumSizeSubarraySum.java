package main.java.algos.slidingwindow;

/**
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 *
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int [] arr={2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,arr));
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int sum=0;
        int result=Integer.MAX_VALUE;
        int left=0;int right=0;
        while(right<nums.length){

            sum=sum+nums[right];

            if(sum>=target){
                result=Math.min(result,right-left+1);
            }

            while(left<=right && sum>=target){
                result=Math.min(result,right-left+1);
                sum=sum-nums[left];
                left++;
            }

            right++;
        }
        if(sum<target && left==0){
            return 0;
        }
        return result;
    }
}
