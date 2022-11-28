package model.state;

import model.ATM;
import model.Card;
import model.TransactionType;

public class ATMState {

    public void insertCard(ATM atm, Card card) {
        System.out.println("OOPS !! Something went wrong.");
    }

    public void authenticateCard(ATM atm, Card card, int pinEntered) {
        System.out.println("OOPS !! Something went wrong.");
    }

    public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
        System.out.println("OOPS !! Something went wrong.");
    }

    public void withdrawCash(ATM atm, Card card, int amountToWithdraw) {
        System.out.println("OOPS !! Something went wrong.");
    }

    public void displayBalance(ATM atm, Card card) {
        System.out.println("OOPS !! Something went wrong.");
    }

    public void returnCard() {
        System.out.println("OOPS !! Something went wrong.");
    }

    public void exit(ATM atm) {
        System.out.println("OOPS !! Something went wrong.");
    }



}
