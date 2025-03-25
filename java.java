
import java.text.NumberFormat;
import java.util.*;

public class java {

    public static void main(String[] args) {

        int mInYear = 12;
        int percent = 100;
        int principal = 0;
        int deposit = 0;
        double annualInterestRate = 0;
        int years = 0;
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
        System.out.print("Enter the principal amount for your loan: ");
        principal = scanner.nextInt();
        if (1000000 > principal && principal > 0) {
            break;
        } else {
            System.out.println("Please enter a valid principal amount.");
        }
        }

        while (true) {
        System.out.println("Enter your deposit amount: ");
        deposit = scanner.nextInt();
        if (deposit < principal && deposit > 0) {
            break;
            } else {
                System.out.println("Please enter a valid deposit.");
            } 
        }

        while (true) {
        System.out.print("Enter the annual interest rate for your loan: ");
        annualInterestRate = scanner.nextDouble();
        if (annualInterestRate > 0 && annualInterestRate < 100) {
            break;
        } else {
            System.out.println("Please enter a valid interest rate.");
        }
        }
        
        while (true) { 
            System.out.println("Enter the term of your loan in years: ");
            years = scanner.nextInt();
            if (years > 0 && years <= 30)
            break;
            else if (years > 30) {
                System.out.println("We do not offer loans longer than 30 years.");
          } else {
            System.out.println("Please enter a valid term.");
          }
        }

        double monthlyInterestRate = annualInterestRate / percent / mInYear;
        int months = years * mInYear;

        double mathPow = Math.pow(1 + monthlyInterestRate, months);
        double monthlyPayment = (principal - deposit) * monthlyInterestRate / (1 - 1 / mathPow);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String payment = formatter.format(monthlyPayment);

        System.out.println("Your monthly payment will be: " + payment);
    }


}