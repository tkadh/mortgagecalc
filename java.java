// Purpose: This program calculates the monthly payment for a loan based on the principal amount, deposit, annual interest rate, and term of the loan.
import java.text.NumberFormat;
import java.util.*;

public class java {

    public static void main(String[] args) {

        
        int principal = 0;
        int deposit = 0;
        double annualInterestRate = 0;
        int years = 0;
        double payment = 0;
        
        Scanner scanner = new Scanner(System.in);

        principal = (int)readNumber("Enter your principal loan: ", 1000, 1000000);
        deposit = (int) readNumber("Enter your deposit amount: ", 0, principal);
        annualInterestRate = (float) readNumber("Enter the annual interest rate for your loan: ", 0, 100);
        years = (int) readNumber("Enter the term of your loan (years): ", 0, 30);

        payment = calculateMortgage(principal, deposit, annualInterestRate, years);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String monthlyPayment = formatter.format(payment);

        System.out.println("Your monthly payment will be: " + monthlyPayment + " over a term of " + years + " years.");
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            } else {
                System.out.println("Enter a value between " + min + " and " + max);
            }
            }
            return value;
    }

    public static double calculateMortgage(
        int principal,
        int deposit,
        double annualInterestRate,
        int years) {
            final int mInYear = 12;
            final int percent = 100;
            double monthlyInterestRate = annualInterestRate / percent / mInYear;
            int months = years * mInYear;
            double mathPow = Math.pow(1 + monthlyInterestRate, months);
            double payment = (principal - deposit) * monthlyInterestRate / (1 - 1 / mathPow);

            return payment;
    }

}