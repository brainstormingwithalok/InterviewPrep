package main.java.algos.string;

public class GetMinNumberFromAlphanumericString {
    public static void main(String[] args) {
        System.out.println(getMin("1000abc35$$12T5555&&&6666"));
    }

    public static int getMin(String s) {
        int num = 0;
        int min = Integer.MAX_VALUE;
        boolean foundNumber = false;
        boolean negative = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                foundNumber = true;
                num = num * 10 + (s.charAt(i) - '0');
            } else if (c == '-' && !foundNumber && i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                negative = true;
            } else {
                if (foundNumber) {
                    if (negative) {
                        num = -num;
                        negative = false;
                    }
                    min = Math.min(min, num);
                    num = 0;
                    foundNumber = false;
                }
            }

        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }
}
