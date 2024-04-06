package main.java.algos.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an array of meeting time intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.



Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 */
public class MinimumMeetingRooms {
    public static void main(String[] args) {
        int[][] intervals={{1,10},{2,7},{3,19},{8,12},{10,20},{11,30}};
        //Expected =4
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        //base case
        if (intervals.length == 0) {
            return 0;
        }
        if (intervals.length == 1) {
            return 1;
        }
        //sort the array based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int first = pq.peek();
            //that means meeting over remove from queue
            if (interval[0] >= first) {
                pq.poll();
            }
            //Add in the queue all the time
            pq.add(interval[1]);
        }
        return pq.size();
    }
}
