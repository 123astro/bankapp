package com.careerdevs;


// base class
// Abstract

public abstract class Account {

    // account number
    private int accountNumber;

    // balance
    protected double balance;

    // Default constructor
    public Account() {
    }

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        balance = 0;
    }

    // getter methods

    public double getBalance() {
        return this.balance;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }

  // no set balance

    //Abstract methods

    /**
     * Function  to deposit funds into the account as long as the amount parameter is > 0
     * Apply Transaction fee for Checking Account
     * @param amount value to be deposited
     */
    public abstract void deposit(double amount );

    /**
     * Function to withdraw funds from the account as long as
     * 1 Amount to withdraw must be > 0
     * 2 Amount to withdraw must be <= balance
     * @param amount value to be withdrawn
     */

    public abstract void withDraw(double amount);

}
