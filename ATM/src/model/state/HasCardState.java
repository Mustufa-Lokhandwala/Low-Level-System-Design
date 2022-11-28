package model.state;

import model.ATM;
import model.Card;

public class HasCardState extends ATMState {
    public void authenticateCard(ATM atm, Card card, int pinEntered) {
        if(card.getPin() == pinEntered) {
            System.out.println("Correct pin entered. You are authenticated.");
            atm.setAtmState(new SelectOperationState());
        }
        else {
            System.out.println("Invalid pin entered.");
            exit(atm);
        }
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
