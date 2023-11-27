package com.example.searchAndSorting;

public class InsertionSort {

    public static int[] sort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j - 1] > a[j]) { //swap
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                } else break;
            }
        }
        return a;

    }


}