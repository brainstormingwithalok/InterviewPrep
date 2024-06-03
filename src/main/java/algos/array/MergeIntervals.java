package main.java.algos.array;

import java.util.*;

/**
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array of the non-overlapping
 * intervals that cover all the intervals in the input.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {

    public static void main(String[] args) {

        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] input={{1,4},{0,4}};
        int[][] output = merge(input);

    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //In case of list sort use //Collections.sort(intervals,(a,b)-> a.get(0).compareTo(b.get(0)));
        result.add(intervals[0]);
        for (int[] interval : intervals) {
            int x1 = result.get(result.size() - 1)[0];
            int y1 = result.get(result.size() - 1)[1];
            int x2 = interval[0];
            int y2 = interval[1];
            if (y1 >= x2) {
                result.get((result.size() - 1))[1] = Math.max(y1, y2);
            } else {
                result.add(interval);
            }


        }

        return result.toArray(new int[result.size()][]);

    }

}


