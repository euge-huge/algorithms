package laba1;

import java.util.concurrent.TimeUnit;

public class Laba1_1 {
    public static void main(String[] args) {
        int width = 30;
        int height = 30;
        int[][] array = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                array[i][j] = (int) (-100 + Math.random() * 200);
            }
        }

//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                System.out.print(array[i][j] + "\t");
//            }
//            System.out.print('\n');
//        }

        long timeStart = System.nanoTime();
        int[][] newArray = refactorArray(array);
        long timeEnd = System.nanoTime();

//        System.out.println("\nИзмененный массив: ");
//        for (int i = 0; i < newArray.length; i++) {
//            for (int j = 0; j < newArray[i].length; j++) {
//                System.out.print(newArray[i][j] + "\t");
//            }
//            System.out.print('\n');
//        }

        System.out.println("TIME: " + TimeUnit.NANOSECONDS.toMillis((timeEnd - timeStart)) + "ms");

    }

    public static int[][] refactorArray(int[][] array) {

        int minOf7 = 0;
        int[] minD7Col = new int[array.length];
        int indexMinC = 0;

        int maxS = 0;
        int[] colM = new int[array.length];
        int indexMaxC = 0;

        for(int i=0; i< minD7Col.length; i++){
            minD7Col[i] = array[i][0];
            colM[i] = array[i][0];

            if (array[i][0] % 7 == 0) ++minOf7;
            if (array[i][0] % 2 == 0) maxS = maxS + array[i][0];
        }

        for (int i = 0; i < array.length; i++) {
            int[] column7 = new int[array.length];
            int[] columnM = new int[array.length];

            int amountOfD7 = 0;
            int maxSum = 0;
            for (int j = 0; j < array[i].length; j++) {
                column7[j] = array[j][i];
                columnM[j] = array[j][i];

                if (array[j][i] % 7 == 0) {
                    ++amountOfD7;
                };
                if (array[j][i] % 2 == 0) {
                    maxSum = maxSum + array[i][0];
                };
            }
            if (amountOfD7 <= minOf7) {
                minD7Col = column7;
                minOf7 = amountOfD7;
                indexMinC = i;
            }

            if (maxSum >= maxS) {
                colM = columnM;
                maxS = maxSum;
                indexMaxC = i;
            }
        }

//        System.out.println("\nКолонка с минимальным кол-вом чисел кр. 7: ");
//        for(int i=0; i< minD7Col.length; i++){
//            System.out.println(minD7Col[i]);
//        }
//        System.out.println("Номер колонки: " + (indexMinC + 1));

//        System.out.println("\nКолонка с максимальной суммой четных чисел: ");
//        for(int i=0; i< colM.length; i++){
//            System.out.println(colM[i]);
//        }
//        System.out.println("Номер колонки: " + (indexMaxC + 1));

        for (int i = 0; i < array.length; i++ ) {
            int temp = 0;
            temp = array[i][indexMinC];
            array[i][indexMinC] = array[i][indexMaxC];
            array[i][indexMaxC] = temp;
        }
        return array;
    };

}



