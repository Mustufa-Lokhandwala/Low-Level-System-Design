package model;

public class Card {
    private int cardNo;
    private int cvv;
    private String expiryDate;
    private String cardHolderName;
    private int pin;
    private BankAccount bankAccount;

    public Card(int cardNo, int cvv, String expiryDate, String cardHolderName, int pin, BankAccount bankAccount) {
        this.cardNo = cardNo;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.cardHolderName = cardHolderName;
        this.pin = pin;
        this.bankAccount = bankAccount;
    }

    public int getCardNo() {
        return cardNo;
    }

    public int getCvv() {
        return cvv;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public int getPin() {
        return pin;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
