package model.state;

import model.ATM;
import model.Card;

public class IdleState extends ATMState {
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted in the atm machine.");
        atm.setAtmState(new HasCardState());
    }
}
