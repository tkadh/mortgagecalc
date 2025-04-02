// Purpose: This program calculates the monthly payment for a loan based on the principal amount, deposit, annual interest rate, and term of the loan.
import java.text.NumberFormat;
import java.util.*;

public class LoanCalculator {

        final static int mInYear = 12;
        final static int percent = 100;
        public static void main(String[] args) {
            // Read user inputs
            int principal = (int) readNumber("Enter your principal loan: ", 1000, 1000000);
            int deposit = (int) readNumber("Enter your deposit amount: ", 0, principal);
            int totalPrincipal = principal - deposit;
            float annualInterestRate = (float) readNumber("Enter the annual interest rate for your loan: ", 0, 100);
            int years = (int) readNumber("Enter the term of your loan (years): ", 1, 30);
            // Calculate the monthly payment
            double payment = calculateMortgage(principal, deposit, annualInterestRate, years);
            // Format the payment as currency
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String monthlyPayment = formatter.format(payment);

            if (totalPrincipal >= 1000) {
                System.out.println();
            } else {
                System.out.println("You don't need a loan!!! Pay in full!");
            }

            System.out.println();
            System.out.println("Your monthly payment will be: " + monthlyPayment + " over a term of " + years + " years."); 
            
            System.out.println();
            System.out.println("Payment Schedule:");
            for (short month = 1; month <= years * mInYear; month++) {
                double balance = calculateBalance(principal, deposit, annualInterestRate, years, month);
                System.out.println("Month " + month + ": " + formatter.format(balance));
            
        }
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

                return value;
        }
    
        // Method to calculate the monthly payment
        public static double calculateMortgage(
            int principal,
            int deposit,
            double annualInterestRate,
            int years) {
                double monthlyInterestRate = annualInterestRate / percent / mInYear;
                int months = years * mInYear;
            double mathPow = Math.pow(1 + monthlyInterestRate, months);
            double payment = (principal - deposit) * monthlyInterestRate / (1 - 1 / mathPow);

            return payment;
    }

    public static double calculateBalance(int principal,
    int deposit,
    double annualInterestRate,
    int years,
    short numberOfPaymentsMade) {
            double monthlyInterestRate = annualInterestRate / percent / mInYear;
            int months = years * mInYear;

            double balance = (principal - deposit) * (Math.pow(1 + monthlyInterestRate, months) - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade)) 
            / (Math.pow(1 + monthlyInterestRate, months) - 1);

            return balance;
            
    }
}
