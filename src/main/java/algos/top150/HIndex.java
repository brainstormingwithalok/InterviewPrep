package main.java.algos.top150;

import java.util.Arrays;

/**
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 *
 *
 *
 * Example 1:
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 * Example 2:
 *
 * Input: citations = [1,3,1]
 * Output: 1
 */
public class HIndex {
    public static void main(String[] args) {
        int [] arr={0,1,2,3,7,8};

//        System.out.println(hIndex(arr));
        System.out.println(hIndexExtraSpace(arr));
    }

    //Binary search with no extra space
    //Case 1: 0,1,2,3,7,8 {answer in the array}
    //Case 2: 1,5,6,7,8  {answer not in array}
    public static int hIndex(int[] citations) {

        int left=0;
        int right=citations.length-1;
        Arrays.sort(citations);
        while(left<=right){
            int mid=left+(right-left)/2;
            if(citations[mid]==citations.length-mid){
                return citations[mid];
            }
            else if (citations[mid]>citations.length-mid){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }

        return citations.length-left;
    }

    //Without binary search with extra space
    public static int hIndexExtraSpace(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        // counting papers for each citation number
        for (int c: citations)
            papers[Math.min(n, c)]++;
        // finding the h-index
        int k = n;
        for (int s = papers[n]; k > s; s += papers[k])
            k--;
        return k;
    }

}
