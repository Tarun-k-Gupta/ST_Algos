package com.example.dp;

public class FibonacciNumber {

    public int fib(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 0;
        if (n == 2) return 1;
    
        int f1 = 0;
        int f2 = 1;
        int result = 0;
    
        for (int i = 3; i <= n; i++) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }
    
        return result;
    }
    
    public int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;
    
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 1;
    
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
    
        return memo[n];
    }
    
}