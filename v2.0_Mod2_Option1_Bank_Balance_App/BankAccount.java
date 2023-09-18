// Class represents a simple Bank Account with methods for deposit, withdrawal, and balance retrieval.
public class BankAccount {
    private double balance;  // Instance variable stores current balance

    // Constructor initializes the balance with an initial amount
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit amount into the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw amount from the account
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }                   // Exception if user tries to withdraw more than the balance.
        balance -= amount;
    }

    // Method retrieves the current balance
    public double getBalance() {
        return balance;
    }
}
