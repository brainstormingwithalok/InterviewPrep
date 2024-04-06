package main.java.algos.recursionandbacktracking;

public class NumberRelatedUsingRecursion {
    public static void main(String[] args) {
//        print3(5);
//        System.out.println(System.currentTimeMillis());
//        System.out.println(calculatePow(2,5));
//        System.out.println(System.currentTimeMillis());
        int[] arr = {22, 33, 4, 19, 7};
        System.out.println(findMax(arr, 0));
    }

    public static int findMax(int[] x, int idx) {
        if (idx == x.length) {
            return x[idx - 1];
        }
        int subMax = findMax(x, idx + 1);
        if (subMax > x[idx]) {
            return subMax;
        } else {
            return x[idx];
        }
    }

    public static void displayArr(int[] x, int idx) {
        if (idx >= x.length) {
            return;
        }
        System.out.println(x[idx]);
        displayArr(x, idx + 1);
    }

    public static int calculatePow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int res = calculatePow(x, n / 2);
        int pow = res * res;
        if (n % 2 == 1) {
            pow = pow * x;
        }
        return pow;
    }

    public static int pow(int x, int n) {

        if (n == 0) {
            return 1;
        }
        int fReturn = pow(x, n - 1);
        int val1 = x * fReturn;
        return val1;
    }

    public static int fact(int n) {

        if (n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    /**
     * Print in increasing order
     *
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
     *
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
     *
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
