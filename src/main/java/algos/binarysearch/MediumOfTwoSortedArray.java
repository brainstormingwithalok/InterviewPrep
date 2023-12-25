package main.java.algos.binarysearch;

/**
 * https://www.youtube.com/watch?v=_TCw4LXpKq0&t=659s
 *
 *       x    y
 * a-> 0,2,| 3,8 |
 *         p  q
 * b->1,4,5,| 7,9
 *
 * 4+5 -> 9 >5 O(m+n)
 *
 * odd -> lot 1 (5) , lot2 (4)
 * even -> 8- > lot 1 (4) , lot2 (4)
 *
 *
 *
 *
 * lot1-> 0,2,1,4,5
 * lot2,-> 3,8,7,9
 *
 *
 *
 * 2<=7
 * 5<=3
 *
 * x<=q
 * p<=y
 *
 * lot1-> 0,2,3,1,4
 * lot2,-> 8,5,7,9
 * 3<=5
 * 4<=8
 *
 *
 * a- >  [min,1,2,| 3,4,max]
 * b-> [min,2,4,6, | 8,10,12,max]
 *
 *
 * 2<=8
 * 6<=3
 */

import jdk.internal.util.xml.impl.Pair;

/**
 *
 */
public class MediumOfTwoSortedArray {
    public static void main(String[] args) {

        int[] nums1={1,2,3,4};
        int[] nums2={2,4,6,8,10,12};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int minRightA = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];
            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minRightB = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                right = partitionA - 1;
            } else {
                left = partitionA + 1;
            }
        }
        return 0.0;
    }

}
