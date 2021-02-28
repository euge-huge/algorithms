package laba1;


// Подсчитать количества положительных элементов целочисленной матрицы
// A[M*N], стоящих на пересечении нечетных строк и столбцов


import java.util.concurrent.TimeUnit;

public class Laba1_2 {
    public static void main(String[] args) {
        int width = 5;
        int height = 10;
        int[][] array = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                array[i][j] = (int) (-100 + Math.random() * 200);
            }
        }

        for (int i = 0; i <= array[0].length; i++) {
            if (i == 0) System.out.print("\t"); else System.out.print((i-1) + "\t");
        }
        System.out.println("");
        for (int i = 0; i <= array[0].length; i++) {
            if (i == 0) System.out.print("\t"); else System.out.print("-\t");
        }
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.print('\n');
        }

        long timeStart = System.nanoTime();
        int amount = calculatePositive(array);
        long timeEnd = System.nanoTime();

        System.out.println("\nКоличество положительных элементов: " + amount + "\n");

        System.out.println("TIME: " + TimeUnit.NANOSECONDS.toMillis((timeEnd - timeStart)) + "ms");
    }

    public static int calculatePositive(int[][] array) {

        int amontPositive = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ((i % 2 != 0) && (j % 2 != 0) && array[i][j] > 0) ++amontPositive;
            }
        }

        return amontPositive;
    }
}
