package com.example.searchAndSorting;

public class HeapSort {
	
	private static void heapify(int[] arr, int root, int heapSize) {
		int maximum = root;					
		int leftChild = 2 * root + 1;
		int rightChild = 2 * root + 2;

		
		if (leftChild < heapSize && arr[leftChild] > arr[root])
			maximum = leftChild;
		if (rightChild < heapSize && arr[rightChild] > arr[maximum])
			maximum = rightChild;

		
		if (root != maximum) {
			int temp = arr[root];
			arr[root] = arr[maximum];
			arr[maximum] = temp;
			heapify(arr, maximum, heapSize);
		}
	}

	public static int[] heapSort(int[] arr, int heapSize) {
		for (int i = heapSize / 2 - 1; i >= 0; i--)
			heapify(arr, i, heapSize);

		
		for (int i = heapSize - 1; i > 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			heapSize--;
			heapify(arr, 0, heapSize);
		}
        return arr;
	}

}