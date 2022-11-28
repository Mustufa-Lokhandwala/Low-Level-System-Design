package model.state;

import model.ATM;
import model.BankAccount;
import model.Card;

public class DisplayBalanceState extends ATMState {

    public void displayBalance(ATM atm, Card card) {
        BankAccount bankAccount = card.getBankAccount();
        System.out.println("Your account has Rs: " + bankAccount.getBalance());
        exit(atm);
    }

    public void exit(ATM atm) {
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("Exit happens.");
    }

    public void returnCard() {
        System.out.println("Please collect your card.");
    }

}
