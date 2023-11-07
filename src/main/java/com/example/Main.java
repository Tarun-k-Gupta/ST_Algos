package com.example;

// /**
//  * Hello world!
//  *
//  */
// public class Main 
// {
//     public static void main( String[] args )
//     {
//         System.out.println( "Hello World!" );
//     }
// }

// package org.cal;

// import java.util.Scanner;
// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;

// public class Main {
//     private static final Logger logger = LogManager.getLogger(Main.class);

//     public static void main(String[] args) {
//         System.out.println("Enter a number to start the program");
//         Scanner sc = new Scanner(System.in);
//         sc.nextLine();
//         while (true) {
//             System.out.println("**********************************CALCULATOR**********************************");
//             System.out.println("What do you want to do ?");
//             System.out.println("1.Square root \n2.Factorial  \n3.Natural Log \n4.Power \nAny other integer to Quit");
//             System.out.print("\n Enter your choice : ");
//             int ch = sc.nextInt();
//             double res = 0;
//             double num, pow;
//             switch (ch) {
//                 case (1): // SquareRoot
//                     System.out.print("Enter no : ");
//                     num = sc.nextDouble();
//                     res = squareroot(num);
//                     break; // Factorial
//                 case (2):
//                     do {
//                         System.out.print("Enter no : ");
//                         num = (int) sc.nextDouble();
//                         if (num < 0)
//                             System.out.println("Please enter a positive no. !!!");
//                     } while (num < 0);
//                     res = factorial(num);
//                     break;
//                 case (3): // Natural Log
//                     System.out.print("Enter no : ");
//                     num = sc.nextDouble();
//                     res = log(num);
//                     break;
//                 case (4): // Power
//                     System.out.print("Enter no : ");
//                     num = sc.nextDouble();
//                     System.out.print("Enter power : ");
//                     pow = sc.nextDouble();
//                     res = power(num, pow);
//                     break;
//                 default:
//                     System.out.println("Closing the application");
//                     return;
//             }
//             System.out.println("Result : " + res);
//         }
//     }

//     public static double squareroot(double n) {
//         logger.info("[SQ ROOT] - " + n);
//         double res = Math.sqrt(n);
//         logger.info("[RESULT - SQ ROOT] - " + res);
//         return res;
//     }

//     public static double factorial(double n) {
//         logger.info("[FACTORIAL] - " + n);
//         double res = 1L;
//         for (int i = 1; i <= n; i++) {
//             res *= i;
//         }
//         logger.info("[RESULT - FACTORIAL] - " + res);
//         return res;
//     }

//     public static double log(double n) {
//         logger.info("[NATURAL LOG] - " + n);
//         double res = Math.log(n);
//         logger.info("[RESULT - NATURAL LOG] - " + res);
//         return res;
//     }

//     public static double power(double n, double p) {
//         logger.info("[POWER - " + n + " RAISED TO] " + p);
//         double res = Math.pow(n, p);
//         logger.info("[RESULT - POWER] - " + res);
//         return res;
//     }
// }

// package org.cal;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("Enter a number to start the program");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        while (true) {
            System.out.println("**********************************CALCULATOR**********************************");
            System.out.println("Welcome to the calculator program!!");
            System.out.println("1.Square root \n2.Factorial  \n3.Natural Log \n4.Power \nAny other integer to Quit");
            System.out.print("\n Enter your choice : ");
            int ch = sc.nextInt();
            double res = 0;
            double num, pow;
            switch (ch) {
                case (1): // SquareRoot
                    System.out.print("Enter no : ");
                    num = sc.nextDouble();
                    res = squareroot(num);
                    break; // Factorial
                case (2):
                    do {
                        System.out.print("Enter no : ");
                        num = (int) sc.nextDouble();
                        if (num < 0)
                            System.out.println("Please enter a positive no. !!!");
                    } while (num < 0);
                    res = factorial(num);
                    break;
                case (3): // Natural Log
                    System.out.print("Enter no : ");
                    num = sc.nextDouble();
                    res = log(num);
                    break;
                case (4): // Power
                    System.out.print("Enter no : ");
                    num = sc.nextDouble();
                    System.out.print("Enter power : ");
                    pow = sc.nextDouble();
                    res = power(num, pow);
                    break;
                default:
                    System.out.println("Closing the application");
                    return;
            }
            System.out.println("Result : " + res);
        }
    }

    public static double squareroot(double n) {
        logger.info("[SQ ROOT] - " + n);
        double res = Math.sqrt(n);
        logger.info("[RESULT - SQ ROOT] - " + res);
        return res;
    }

    public static double factorial(double n) {
        logger.info("[FACTORIAL] - " + n);
        double res = 1L;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        logger.info("[RESULT - FACTORIAL] - " + res);
        return res;
    }

    public static double log(double n) {
        logger.info("[NATURAL LOG] - " + n);
        double res = Math.log(n);
        logger.info("[RESULT - NATURAL LOG] - " + res);
        return res;
    }

    public static double power(double n, double p) {
        logger.info("[POWER - " + n + " RAISED TO] " + p);
        double res = Math.pow(n, p);
        logger.info("[RESULT - POWER] - " + res);
        return res;
    }
}