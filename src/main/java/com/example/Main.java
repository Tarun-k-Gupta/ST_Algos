package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Press any key to begin the program!");
        Scanner inputScanner = new Scanner(System.in);
        inputScanner.nextLine();
        while (true) {
            System.out.println("You have the following choices..");
            System.out.println(
                    "1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n Press any other key to Quit");
            System.out.print("\nEnter your choice: ");
            int choice = inputScanner.nextInt();
            double result = 0;
            double num1, num2;
            switch (choice) {
                case 1: // Adding two numbers
                    System.out.print("Enter the first number: ");
                    num1 = inputScanner.nextDouble();
                    System.out.print("Enter the second number: ");
                    num2 = inputScanner.nextDouble();
                    result = add(num1, num2);
                    break;
                case 2: // Subtraction of two numbers
                    System.out.print("Enter the first number: ");
                    num1 = inputScanner.nextDouble();
                    System.out.print("Enter the second number: ");
                    num2 = inputScanner.nextDouble();
                    result = subtract(num1, num2);
                    break;
                case 3: // Multiplication of two numbers
                    System.out.print("Enter the first number: ");
                    num1 = inputScanner.nextDouble();
                    System.out.print("Enter the second number: ");
                    num2 = inputScanner.nextDouble();
                    result = multiply(num1, num2);
                    break;
                case 4: // Division of two numbers
                    System.out.print("Enter the numerator: ");
                    num1 = inputScanner.nextDouble();
                    do {
                        System.out.print("Enter the denominator (non-zero): ");
                        num2 = inputScanner.nextDouble();
                        if (num2 == 0)
                            System.out.println("Denominator must be non-zero! Please enter again.");
                    } while (num2 == 0);
                    result = divide(num1, num2);
                    break;
                default:
                    System.out.println("Quitting the program.....");
                    return;
            }
            System.out.println("Result: " + result);
        }
    }

    public static double add(double num1, double num2) {
        double result = num1 + num2;
        return result;
    }

    public static double subtract(double num1, double num2) {
        double result = num1 - num2;
        return result;
    }

    public static double multiply(double num1, double num2) {
        double result = num1 * num2;
        return result;
    }

    public static double divide(double num1, double num2) {
        double result = num1 / num2;
        return result;
    }

}