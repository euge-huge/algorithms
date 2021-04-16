package laba4;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class SortAlgorithms {
    public static boolean lineForDis(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return true;
            }
        }
        return false;
    }

    public static boolean fastLineForDis(int[] arr, int key) {
        if (arr[arr.length - 1] == key) return true;
        int temp = arr[arr.length - 1];
        arr[arr.length - 1] = key;

        int i = 0;

        while (arr[i] != key) {
            i++;
        }

        if (i != (arr.length - 1)) {
            arr[arr.length - 1] = temp;
            return true;
        }


        arr[arr.length - 1] = temp;
        return false;
    }

    public static boolean fastLineForOrd(int[] arr, int key) {
        if (arr[arr.length - 1] == key) return true;
        int temp = arr[arr.length - 1];
        arr[arr.length - 1] = key;

        int i = 0;
        while (arr[i] <= key) {
            if (arr[i] == key) {
                arr[arr.length - 1] = temp;
                break;
            }
            i++;
        }

        if (i != (arr.length - 1)) return true;

        arr[arr.length - 1] = temp;
        return false;
    }

    public static boolean binForOrd(int[] arr, int key) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        // условие прекращения (элемент не представлен)
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            // если средний элемент - целевой элемент, вернуть его индекс
            if (arr[middleIndex] == key) {
                return true;
            }

            // если средний элемент меньше
            // направляем наш индекс в middle+1, убирая первую часть из рассмотрения
            else if (arr[middleIndex] < key)
                firstIndex = middleIndex + 1;

                // если средний элемент больше
                // направляем наш индекс в middle-1, убирая вторую часть из рассмотрения
            else if (arr[middleIndex] > key)
                lastIndex = middleIndex - 1;

        }
        return false;
    }

    public static boolean blockForOrd(int[] arr, int key) {
        int divider = 4;
        int celoe = arr.length / divider;
        int ostatok = arr.length % divider;

        if (celoe == 0) {
            return SortAlgorithms.lineForDis(arr, key);
        }
        for (int i = 0; i < divider; i++) {
            if (arr[celoe * i + celoe - 1] == key)
                return true;
            if (arr[celoe * i + celoe - 1] > key) {
                int[] newArr = Arrays.copyOf(Arrays.copyOfRange(arr, celoe * i, arr.length), celoe);
                return SortAlgorithms.blockForOrd(newArr, key);
            }
            if (ostatok != 0) {
                int[] newArr = Arrays.copyOf(Arrays.copyOfRange(arr, divider * celoe, arr.length), ostatok);
                if (SortAlgorithms.blockForOrd(newArr, key)) {
                    return true;
                }
            }
        }
        return false;
    }
}