package com.careerdevs;

import java.security.PrivilegedAction;

// checking account
public class CheckingAccount extends Account {

    // Default Transaction fee
    private static double FEE = 2.5;

    // default constructor
    public CheckingAccount() {
        super();
    }

    /**
     * Parameter constructor to inital ized CheckingAccount
     * with a custom Account Number and Customer Transaction
     * fee.
     */

    public CheckingAccount(int accountNumber, double fee) {
        super(accountNumber);
        FEE = fee;
    }

    /**
     * Function  to deposit funds into the account as long as the amount parameter is > 0
     * Apply Transaction fee for Checking Account
     *
     * @param amount value to be deposited
     */
    public void deposit(double amount) {
        // First Check amount
        if (amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);

            //Apply Transaction Fee
            balance -= FEE;
            System.out.printf("Fee %.2f applied%n", FEE);
            System.out.printf("Current Balance is: %.2f%n", balance);
        } else {
            System.out.println("A negative amount cannot be deposited");
        }
    }

    /**
     * Function to withdraw funds from the account as long as
     * 1 Amount to withdraw must be > 0
     * 2 Amount to withdraw must be <= balance
     *
     * @param amount value to be withdrawn
     */

    public void withDraw(double amount) {
        // same check

        if (amount > 0) {
            if ((amount + FEE) <= balance) {
                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                balance -= FEE;
                System.out.printf("Fee of %.2f applied%n", FEE);
                System.out.printf("Current Balance is: %.2f%n", balance);
            }

        } else {
            System.out.println("A negative amount cannot be withdrawn");
        }
    }
}
