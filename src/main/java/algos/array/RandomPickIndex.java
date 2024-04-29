package main.java.algos.array;

import java.util.Random;

public class RandomPickIndex {
    private Random rand;
    private int[] nums;
    private int K = 1;

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,3,3};
        RandomPickIndex rn=new RandomPickIndex(nums);
        System.out.println(rn.pick(3));
    }
    public RandomPickIndex(int[] nums) {
        rand = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (rand.nextInt(count) < K) {
                    result = i;
                }
            }
        }
        return result;
    }
}
