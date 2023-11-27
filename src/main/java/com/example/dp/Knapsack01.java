package com.example.dp;

public class Knapsack01 {

    public static int[][] knapsack(int[] values, int[] weights, int k) {
        int[][] a = new int[values.length][k + 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a[i].length; j++) {
                if (i == 0) {
                    if (weights[i] <= j)
                        a[i][j] = values[i];
                } else {
                    if (j < weights[i])
                        a[i][j] = a[i - 1][j];
                    else
                        a[i][j] = Math.max(a[i - 1][j], values[i] + a[i - 1][j - weights[i]]);
                }
            }
        }
        return a;
    }


}