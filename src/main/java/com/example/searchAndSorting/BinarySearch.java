package com.example.searchAndSorting;

public class BinarySearch {
    
    public static int search(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] == key) return mid; // key found

            if (a[mid] < key) lo = mid + 1;
            else hi = mid - 1;
        }

        return -(lo + 1); 
    }

    public static int searchLowerBound(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] == key && (mid == 0 || a[mid - 1] != key)) return mid; // key found

            if (a[mid] < key) lo = mid + 1; 
            else hi = mid - 1;
        }

        return -(lo + 1); // key not found, position to be inserted is returned
    }

    public static int searchUpperBound(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] == key && (mid == a.length - 1 || a[mid + 1] != key)) return mid; // key found

            if (a[mid] <= key) lo = mid + 1; 
            else hi = mid - 1;
        }

        return -(hi + 1); // key not found, position to be inserted is returned
    }
}