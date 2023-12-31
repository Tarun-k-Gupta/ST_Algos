package com.example.searchAndSorting;

public class MergeSort {

    public static int[] sort(int[] a) {
        int[] helper = new int[a.length];
        sort(a, 0, a.length - 1, helper);
        return a;
    }

    private static void sort(int[] a, int lo, int hi, int[] helper) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid, helper);
        sort(a, mid + 1, hi, helper);
        merge(a, lo, mid, hi, helper);
    }

    private static void merge(int[] a, int lo, int mid, int hi, int[] helper) {

        for (int i = lo; i <= hi; i++) helper[i] = a[i];
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = helper[j++];
            else if (j > hi)
                a[k] = helper[i++];
            else if (helper[i] <= helper[j])
                a[k] = helper[i++];
            else
                a[k] = helper[j++];
        }

    }

}