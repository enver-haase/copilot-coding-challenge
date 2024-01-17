package org.vaadin.challenges.sort;

import java.util.Arrays;
import java.util.Random;

public class BogoSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 3, 1};
        System.out.println("Before sorting: " + Arrays.toString(array));

        while (!isSorted(array)) {
            shuffleArray(array);
        }

        System.out.println("After sorting: " + Arrays.toString(array));
    }

    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
