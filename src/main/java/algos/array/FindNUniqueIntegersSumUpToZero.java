package main.java.algos.array;

/*
Given an integer n, return any array containing n unique integers such that they add up to 0.



Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:

Input: n = 3
Output: [-1,0,1]
Example 3:

Input: n = 1
Output: [0]
 */
public class FindNUniqueIntegersSumUpToZero {
    public static void main(String[] args) {
        int result[] = sumZero(10);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }


    public static int[] sumZero(int n) {
        //Symmetric numbers (X,-X) one negative and one positive
        int[] result = new int[n];
        int count = 0;
        for (int i = 1; i <= n / 2; i++) {
            result[count++] = i;
            result[count++] = -i;
        }
        //In case of odd add one more zero at first position
        if (n % 2 == 1) {
            result[count] = 0;
        }
        return result;
    }
}
