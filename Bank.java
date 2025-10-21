package BankAccount;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    // Add a new account
    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account added: " + account.getAccountNumber());
    }

    // Find account by account number
    public BankAccount findAccount(String accountNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    // Get all accounts
    public List<BankAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }

    // Apply interest to all accounts
    public void applyInterestToAll(double rate) {
        for (BankAccount acc : accounts) {
            acc.addInterest(rate);
        }
    }
}
