package main.java.algos.backtracking;

public class PrintNums {
    public static void main(String[] args) {
        print3(5);
    }


    /**
     * Print in increasing order
     * @param n
     */
    static void print1(int n) {
        if (n == 0) {
            return;
        }
        print1(n - 1);
        System.out.println(n);
    }

    /**
     * Print in decreasing order
     * @param n
     */
    static void print2(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        print2(n - 1);

    }

    /**
     * Print in decreasing then increasing order
     * @param n
     */
    static void print3(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        print3(n - 1);
        System.out.println(n);
    }

}
