package main.java.algos.array;

import java.util.Random;

public class RandomPickWithWeight {
    public static void main(String[] args) {

        int[] values = { 100, 200, 10, 20, 30, 1, 2, 3 };
        // Shuffle integer array.
        shuffle(values);

        // Display elements in array.
        for (int value : values) {
            System.out.println(value);
        }
    }

    public static void shuffle(int[] values){
        Random random=new Random();
        for(int i=0;i<values.length;i++){
            int index=i+random.nextInt(values.length-i);
            int indexElement=values[index];
            values[index]=values[i];
            values[i]=indexElement;
        }
    }
}
