// Purpose: This program calculates the monthly payment for a loan based on the principal amount, deposit, annual interest rate, and term of the loan.
import java.text.NumberFormat;
import java.util.*;

public class loanCalculator {

    public static void main(String[] args) {

        // Read user inputs
        int principal = (int) readNumber("Enter your principal loan: ", 1000, 1000000);
        int deposit =  (int) readNumber("Enter your deposit amount: ", 0, principal);
        float annualInterestRate = (float) readNumber("Enter the annual interest rate for your loan: ", 0, 100);
        int years = (int) readNumber("Enter the term of your loan (years): ", 1, 30);

        // Calculate the monthly payment
        double payment = calculateMortgage(principal, deposit, annualInterestRate, years);

        // Format the payment as currency
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String monthlyPayment = formatter.format(payment);

        System.out.println("Your monthly payment will be: " + monthlyPayment + " over a term of " + years + " years.");    
    }

    // Method to read user input within specified range
    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);

        double value;
        NumberFormat formatter = NumberFormat.getInstance();

        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            } else {
                System.out.println("Enter a value between " + formatter.format((int)min) + " and " + formatter.format((int)max));
            }
            }
            scanner.close();
            return value;
    }

    // Method to calculate the monthly payment
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