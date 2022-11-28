package model;

public class BankAccount {
    private User user;
    private int balance;

    public BankAccount(User user, int balance) {
        this.user = user;
        this.balance = balance;
    }

    public void withdraw(int amount) {
        balance = balance - amount;
    }

    public User getUser() {
        return user;
    }

    public int getBalance() {
        return balance;
    }
}
