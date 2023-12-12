package main.java.algos;

import java.util.*;

public class Temp {
    public static void main(String[] args) {
        int[] arr={1,2,3,1,1};
        System.out.println(findPeakElement(arr));

    }


    public static int findPeakElement(int[] nums) {
        int left=0;int right=nums.length-1;

        int mid=0;
        if(nums.length==0){
            return 0;
        }

        while(left<right){
            mid=left+ (right-left)/2;

            if(nums[mid]>nums[mid+1]){
                right=mid-1;
            }
            else{
                left=mid;
            }
        }

        return mid;


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
