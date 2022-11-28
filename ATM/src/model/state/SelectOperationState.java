package model.state;

import model.ATM;
import model.Card;
import model.TransactionType;

public class SelectOperationState extends ATMState {
    public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
        switch(transactionType) {
            case CASH_WITHDRAWAL:
                atm.setAtmState(new CashWithdrawalState());
                break;
            case DISPLAY_BALANCE:
                atm.setAtmState(new DisplayBalanceState());
                break;
            default:
                System.out.println("Invalid operation provided.");
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
