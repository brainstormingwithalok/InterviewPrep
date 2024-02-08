package main.java.algos.backtracking;

public class Permutation {
    public static void main(String[] args) {
        int nBoxes = 4;
        int rItems = 2;
        permutations(new int[nBoxes], 1, rItems);
    }


    static void permutations(int[] boxes, int currentItem, int totalItem) {

        if (currentItem > totalItem) {
            for (int i = 0; i < boxes.length; i++) {
                System.out.print(boxes[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = currentItem;
                permutations(boxes, currentItem + 1, totalItem);
                boxes[i] = 0;
            }
        }
    }

}
