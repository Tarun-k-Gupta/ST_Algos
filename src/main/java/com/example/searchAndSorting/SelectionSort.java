package com.example.searchAndSorting;

public class SelectionSort {

    public static int[] sortt(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            int current = a[i];
            while (j > 0 && current < a[j - 1])
                a[j] = a[--j];
            a[j] = current;
        }
        return a;
    }
}