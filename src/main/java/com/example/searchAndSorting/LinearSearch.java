package com.example.searchAndSorting;

public class LinearSearch {

	public static boolean linearSearch(int[] array, int element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element)
				return true;
		}
		return false;
	}

}
