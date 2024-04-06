package main.java.algos.metrix2d;

import java.util.ArrayList;
import java.util.List;

/*
PrepCode: https://www.youtube.com/watch?v=SVFXEqn3Ceo
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int minR = 0;
        int minC = 0;
        int maxR = matrix.length - 1;
        int maxC = matrix[0].length - 1;
        int totalCount = matrix.length * matrix[0].length;
        int currentCount = 0;
        List<Integer> result = new ArrayList<>();
        while (currentCount < totalCount) {
            //first row
            for (int i = minR, j = minC; j <= maxC && currentCount < totalCount; j++) {
                result.add(matrix[i][j]);
                currentCount++;
            }
            minR++;

            //Last column
            for (int i = minR, j = maxC; i <= maxR && currentCount < totalCount; i++) {
                result.add(matrix[i][j]);
                currentCount++;
            }
            maxC--;
            //Last row
            for (int i = maxR, j = maxC; j >= minC && currentCount < totalCount; j--) {
                result.add(matrix[i][j]);
                currentCount++;
            }
            maxR--;

            // first column

            for (int i = maxR, j = minC; i >= minR && currentCount < totalCount; i--) {
                result.add(matrix[i][j]);
                currentCount++;
            }
            minC++;
        }
        return result;
    }
}
