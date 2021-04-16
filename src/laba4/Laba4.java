package laba4;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Laba4 {
    public static void main(String[] args) {
        int[] arr = new int[100000000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000000);
        }

        Arrays.sort(arr);

        long timeStart = System.nanoTime();
        SortAlgorithms.lineForDis(arr, 999999);
        long timeEnd = System.nanoTime();

        long timeStart2 = System.nanoTime();
        SortAlgorithms.fastLineForDis(arr, 999999);
        long timeEnd2 = System.nanoTime();


        Arrays.sort(arr);

//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }

        SortAlgorithms.blockForOrd(arr, 4);

        if (SortAlgorithms.fastLineForDis(arr, 5)) {
            System.out.println("FINDED!!!");
        } else {
            System.out.println("NOOO!!!");
        }


        System.out.println("FIRST: " + TimeUnit.NANOSECONDS.toMillis((timeEnd - timeStart)) + "ms");
        System.out.println("SECOND: " + TimeUnit.NANOSECONDS.toMillis((timeEnd2 - timeStart2)) + "ms");
    }
}
