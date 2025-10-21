package BankAccount;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    private List<Transaction> transactionHistory;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        if (initialBalance > 0) {
            transactionHistory.add(new Transaction("Initial Deposit", initialBalance));
        }
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount));
            System.out.println("Deposited: $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
            System.out.println("Withdrew: $" + amount + ". New balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Current balance: $" + balance);
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Get balance method
    public double getBalance() {
        return balance;
    }

    // Get account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Get holder name
    public String getHolderName() {
        return holderName;
    }

    // Get transaction history
    public List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }

    // Print transaction history
    public void printTransactionHistory() {
        System.out.println("Transaction History for Account: " + accountNumber);
        for (Transaction t : transactionHistory) {
            System.out.println(t);
        }
    }

    // Calculate interest (simple interest for demonstration)
    public void addInterest(double rate) {
        double interest = balance * rate / 100;
        balance += interest;
        transactionHistory.add(new Transaction("Interest", interest));
        System.out.println("Interest added: $" + interest + ". New balance: $" + balance);
    }
}
