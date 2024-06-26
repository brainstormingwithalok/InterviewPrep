package main.java.algos.array;

/*
There is a function signFunc(x) that returns:

1 if x is positive.
-1 if x is negative.
0 if x is equal to 0.
You are given an integer array nums. Let product be the product of all values in the array nums.

Return signFunc(product).



Example 1:

Input: nums = [-1,-2,-3,-4,3,2,1]
Output: 1
Explanation: The product of all values in the array is 144, and signFunc(144) = 1
Example 2:

Input: nums = [1,5,0,2,-3]
Output: 0
Explanation: The product of all values in the array is 0, and signFunc(0) = 0
Example 3:

Input: nums = [-1,1,-1,1,-1]
Output: -1
Explanation: The product of all values in the array is -1, and signFunc(-1) = -1
 */
public class SignOfTheProductOfAnArray {
    public static void main(String[] args) {
        int[] input = {-1, -2, -3, -4, 3, 2, 1};
//result=1 Explanation: The product of all values in the array is 144, and signFunc(144) = 1
        System.out.println(arraySign(input));
    }

    public static int arraySign(int[] nums) {
        //To avoid the overflow make all positive 1 and negative -1
        int sign = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            }
            if (nums[i] < 0) {
                nums[i] = -1;
            } else {
                nums[i] = 1;

            }
            sign = sign * nums[i];
        }
        return sign;
    }
}
