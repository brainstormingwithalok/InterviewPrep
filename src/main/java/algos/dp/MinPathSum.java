package main.java.algos.dp;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.


 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] dp = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(dp));
    }

    public static int minPathSumWithoutSpace(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 1; i < row; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < col; j++) {
            grid[0][j] = grid[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] = Math.min((grid[i - 1][j] + grid[i][j]), (grid[i][j - 1] + grid[i][j]));
            }
        }

        return grid[row - 1][col - 1];
    }

    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min((dp[i - 1][j] + grid[i][j]), (dp[i][j - 1] + grid[i][j]));
            }
        }

        return dp[row - 1][col - 1];
    }
}
