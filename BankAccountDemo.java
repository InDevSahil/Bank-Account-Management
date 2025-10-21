package BankAccount;

import java.util.Scanner;

public class BankAccountDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Bank Account Management System ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. Apply Interest to All Accounts");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter holder name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    BankAccount newAcc = new BankAccount(accNum, name, balance);
                    bank.addAccount(newAcc);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    String depAcc = scanner.nextLine();
                    BankAccount depAccount = bank.findAccount(depAcc);
                    if (depAccount != null) {
                        System.out.print("Enter deposit amount: ");
                        double depAmount = scanner.nextDouble();
                        depAccount.deposit(depAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    String withAcc = scanner.nextLine();
                    BankAccount withAccount = bank.findAccount(withAcc);
                    if (withAccount != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withAmount = scanner.nextDouble();
                        withAccount.withdraw(withAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    String balAcc = scanner.nextLine();
                    BankAccount balAccount = bank.findAccount(balAcc);
                    if (balAccount != null) {
                        System.out.println("Balance: $" + balAccount.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter account number: ");
                    String histAcc = scanner.nextLine();
                    BankAccount histAccount = bank.findAccount(histAcc);
                    if (histAccount != null) {
                        histAccount.printTransactionHistory();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter interest rate (%): ");
                    double rate = scanner.nextDouble();
                    bank.applyInterestToAll(rate);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
