package main.java.algos.array;
//Pre code
//https://www.youtube.com/watch?v=ErPZFxugYkI

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 */
public class NumberOfIslands {
    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(visited[i][j]==false && grid[i][j]=='1'){
                    count++;
                    drawTreeForComponent(grid,i,j,visited);

                }

            }
        }
        return count;
    }

    public static void drawTreeForComponent(char[][] grid,int i, int j,boolean[][] visited){
        if(i<0||i>=grid.length||j<0 || j>=grid[0].length||visited[i][j]==true ||grid[i][j]=='0'){
            return;
        }
        visited[i][j]=true;
        drawTreeForComponent(grid,i-1,j,visited);
        drawTreeForComponent(grid,i+1,j,visited);
        drawTreeForComponent(grid,i,j-1,visited);
        drawTreeForComponent(grid,i,j+1,visited);
    }

}
