package main.java.algos;

import java.util.*;

public class Temp {
    public static void main(String[] args) {
        int[] arr={5,7,7,8,8,10};
        System.out.println(findPeakElement(arr,8));

    }


    public static int[] findPeakElement(int[] nums, int target) {
        int left=0;int right=nums.length-1;
        int[] result={-1,-1};
        int index1=-1; int index2=-1;

        while(left<right){
            int mid=left+ (right-left)/2;

            if(nums[mid]==target){

            }
            if(nums[mid]>target){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }

        return result;


    }

    /*public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }*/

}
