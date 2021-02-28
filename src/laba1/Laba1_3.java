package laba1;

// Найти произведение положительных  элементов  последовательности D1, ... , Dn ,
// расположенных    до    первого    нулевого    элемента, заменить
// этой суммой максимальный элемент массива

import java.util.concurrent.TimeUnit;

public class Laba1_3 {
    public static void main(String[] args) {
        int length = 10;
        long[] array = new long[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (-100 + Math.random() * 200);
        }

//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + "\t");
//        }
//        System.out.println("");

        long timeStart = System.nanoTime();
        refactorArray(array);
        long timeEnd = System.nanoTime();

//        System.out.println("Результат: ");
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + "\t");
//        }
//        System.out.println("");


        System.out.println("TIME: " + TimeUnit.NANOSECONDS.toMillis((timeEnd - timeStart)) + "ms");
    }

    public static void refactorArray(long[] array) {

        long proizv = 1;
        for (int i = 0; i < array.length; i++) {
            if ((array[0] !=0 ) && (array[i] !=0)) {
                if (array[i] > 0) proizv *= array[i];
            } else
                break;
        }

        System.out.println("PR: " + proizv);

        long max = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }

        System.out.println("MAX: " + max);

        array[index] = proizv;
    }
}
