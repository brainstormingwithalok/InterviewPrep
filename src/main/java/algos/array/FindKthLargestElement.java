package main.java.algos.array;

/*

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?



Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
//        System.out.println(findKthElement(nums, 2));
//        System.out.println(findKthLargestMinHeap(nums, 2));
        System.out.println(findKthLargestMaxHeap(nums, 2));
    }

    //Using min heap
    public static int findKthLargestMinHeap(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<Integer>();
        for (int num : nums) {
            q.offer(num);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }

    //Using max heap
    public static int findKthLargestMaxHeap(int[] nums, int k) {
        k = nums.length - k + 1;
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }


    /*
    The partition() method of quick sort returns an integer k
    for the interval [l, h] of the array nums such that nums[l..k-1]
     is less than or equal to nums[k], and nums[k+1..h] is greater
     than or equal to nums[k]. In this case, nums[k] is the kth
     largest element of the array. This feature can be used to
     find the Kth Element of the array. This algorithm for
     finding the Kth Element is called the quick selection algorithm.
    Time complexity O(N), space complexity O(1)
    Can be used only if modification of array elements is allowed
     */
    public static int findKthElement(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private static int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            do {
                ++i;
            }
            while (a[i] < a[l] && i < h);
            do {
                --j;
            }
            while (a[j] > a[l] && j > l);

            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
