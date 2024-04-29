package main.java.algos.dp;

public class Temp {
    public static void main(String[] args) {

        int[][] dp={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(sumPath(dp,0,0,dp[0][0]));
    }

    public static int sumPath(int[][] dp,int down,int right, int val){
        if(down>=dp.length-1 || right>=dp[0].length-1){
            return val;
        }
        int first=sumPath(dp,down+1,right,val+dp[down+1][right]);
        int second=sumPath(dp,down,right+1,val+dp[down][right+1]);
        int result=Math.min(first,second);
        return  result;
    }
}
