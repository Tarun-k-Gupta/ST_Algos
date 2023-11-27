package com.example.searchAndSorting;

public class BubbleSort {

    public static int[] sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean sorted = true;
            
            for (int j = 1; j < a.length - i; j++) {
                if (a[j] < a[j - 1]) { //swap
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                    sorted = false;
                }
            }
            
            if (sorted) break;
        }
        return a;
    }

}