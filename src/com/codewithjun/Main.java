package com.codewithjun;


import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        final int minimumValue = 1000;
        final int maximumValue = 1_000_000;

        int principal;
        float monthlyInterest;
        int numberOfPayments;

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Principal (PHP 1,000 - PHP 1,000,000): ");
            principal = scanner.nextInt();
            if (principal >= minimumValue && principal <= maximumValue)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000: ");
        }
        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest > 0 && annualInterest < 30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value greater than 0 and less than 30");
        }
        while (true) {
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();
            if (years > 1 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value greater than 1 and less than or equal to 30");
        }
        double mortgage = principal * (monthlyInterest * Math.pow(monthlyInterest + 1, numberOfPayments))
                / (Math.pow(monthlyInterest + 1, numberOfPayments) - 1);

        String mortgageFormat = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormat);
    }
}