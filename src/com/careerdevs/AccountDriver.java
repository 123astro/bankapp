package com.careerdevs;

import javax.swing.*;
import java.util.Scanner;

public class AccountDriver {

    //Entry point of program
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        // Create array of accounts

        Account accounts[] = new Account[10];
        int numAccounts = 0;

        int choice;

        do {
            choice = menu(keyboard);
            System.out.println();

            if (choice == 1) {
                accounts[numAccounts++] = createAccount(keyboard);
            } else if (choice == 2) {
                doDeposit(accounts, numAccounts, keyboard);
            } else if (choice == 3) {
                doWithDraw(accounts, numAccounts, keyboard);
            } else if (choice == 4) {
                applyInterest(accounts, numAccounts, keyboard);
            } else {
                System.out.println("GoodBye!");
            }
            System.out.println();
        } while (choice != 5);

    }

    /**
     * @return choice
     */

    public static int accountMenu(Scanner keyboard) {

        System.out.println("Select Account Type");
        System.out.println("Select Account Type");
        System.out.println("1 Checking Account");
        System.out.println("2. Savings Account");

        int choice;
        do {
            System.out.println("Enter choice: ");
            choice = keyboard.nextInt();

        } while (choice < 1 || choice > 2);
        return choice;
    }

    public static int searchAccount(Account account[], int count, int accountNumber) {
        for (int i = 0; i < count; i++) {
            if (account[i].getAccountNumber() == accountNumber) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Function to perform deposit on a selected account
     *
     * @param accounts
     * @param count
     */

    public static void doDeposit(Account accounts[], int count, Scanner keyboard) {
        //Get account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {
            // Amount
            System.out.print("Please enter deposit amount: ");
            double amount = keyboard.nextDouble();
            accounts[index].deposit(amount);
        } else {
            System.out.println("No account exist with this account number." + accountNumber);
        }
    }


    public static void doWithDraw(Account accounts[], int count, Scanner keyboard) {
        //Get account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {
            // Amount
            System.out.print("Please enter with draw amount: ");
            double amount = keyboard.nextDouble();
            accounts[index].withDraw(amount);
        } else {
            System.out.println("No account exist with this account number." + accountNumber);
        }
    }

    public static void applyInterest(Account accounts[], int count, Scanner keyboard) {
        //Get account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {
            //apply interest  must be instance of saving account
            if (accounts[index] instanceof SavingAccount) {
                ((SavingAccount) accounts[index]).applyInterest();
            } else {
                System.out.println("No account exist with this account number." + accountNumber);
            }
        }

    }


    /**
     * Function to create a new account
     */
    public static Account createAccount(Scanner keyboard) {
        Account account = null;
        int choice = accountMenu(keyboard);

        int accountNumber;
        System.out.print(" Enter Account Number: ");
        accountNumber = keyboard.nextInt();

        if (choice == 1) {
            System.out.print("Enter transaction fee: ");
            double fee = keyboard.nextDouble();
            account = new CheckingAccount(accountNumber, fee);
        } else {

            System.out.print("Please enter Interest Rate: ");
            double ir = keyboard.nextDouble();

            account = new SavingAccount(accountNumber, ir);

        }
        return account;
    }

    /**
     * Menu to display options and get the users selection
     *
     * @param keyboard
     * @return choice
     */

    public static int menu(Scanner keyboard) {
        System.out.println("Bank account Menu");
        System.out.println("1, Create new Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Apply Interest");
        System.out.println("5. Quit");

        int choice;

        do {
            System.out.println("Enter choice: ");
            choice = keyboard.nextInt();
        } while (choice < 1 || choice > 5);
        return choice;
    }
}

