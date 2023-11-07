package com.example;

import org.junit.Test;
import org.junit.Assert;

public class AppTest {

    @Test
    public void addPositive() {
        double a = 2;
        double b = 1;
        double expectedResult = 3;
        Assert.assertEquals(expectedResult, Main.add(a, b), 0.001); 
    }

    @Test
    public void addNegative() {
        double a = 2;
        double b = 1;
        double expectedResult = 1;
        Assert.assertNotEquals(expectedResult, Main.add(a, b), 0.001); 
    }

    @Test
    public void subPositive() {
        double a = 2;
        double b = 1;
        double expectedResult = 1;
        Assert.assertEquals(expectedResult, Main.subtract(a, b), 0.001);
    }

    @Test
    public void subNegative() {
        double a = 2;
        double b = 1;
        double expectedResult = 2;
        Assert.assertNotEquals(expectedResult, Main.subtract(a, b));
    }
    

    @Test
    public void mulPositive() {
        double a = 2;
        double b = 1;
        double expectedResult = 2;
        Assert.assertEquals(expectedResult, Main.multiply(a, b), 0.001);
    }

    @Test
    public void mulNegative() {
        double a = 2;
        double b = 1;
        double expectedResult = 1;
        Assert.assertNotEquals(expectedResult, Main.multiply(a, b));
    }

    @Test
    public void dividePositive() {
        double a = 2;
        double b = 1;
        double expectedResult = 2;
        Assert.assertEquals(expectedResult, Main.divide(a, b), 0.001);
    }

    @Test
    public void divideNegative() {
        double a = 2;
        double b = 1;
        double expectedResult = 3;
        Assert.assertNotEquals(expectedResult, Main.divide(a, b));
    }   
}