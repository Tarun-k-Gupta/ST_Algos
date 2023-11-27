package com.example.searchAndSorting;

public class CountingSort {

    public static int[] sort(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++)
            max = Math.max(a[i], max);
        max += 1;
    
        int[] count = new int[max];
        for (int i = 0; i < a.length; i++)
            count[a[i]]++;
    
        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];
    
        int[] sorted = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            int index = count[a[i]] - 1;
            sorted[index] = a[i];
            count[a[i]]--;
        }
        return sorted;
    }
    
}