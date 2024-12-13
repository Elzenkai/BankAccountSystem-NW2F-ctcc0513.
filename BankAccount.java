public class BankAccount {
    private String accountName;
    private double balance;

    public BankAccount(String accountName) {
        this.accountName = accountName;
        this.balance = 0.0;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        } else {
            throw new IllegalArgumentException("Withdraw amount must be positive.");
        }
    }
}
