package model.state;

import model.ATM;
import model.BankAccount;
import model.Card;
import model.prcoessor.CashWithdrawalProcessor;
import model.prcoessor.FiveHundredWithdrawalProcessor;
import model.prcoessor.OneHundredWithdrawalProcessor;
import model.prcoessor.TwoThousandWithdrawalProcessor;

public class CashWithdrawalState extends ATMState {

    public void withdrawCash(ATM atm, Card card, int amountToWithdraw) {
        BankAccount bankAccount = card.getBankAccount();
        if(bankAccount.getBalance() < amountToWithdraw) {
            System.out.println("Balance in account is not sufficient");
            exit(atm);
        }
        else if(atm.getBalance() < amountToWithdraw) {
            System.out.println("ATM does not have sufficient balance for withdrawal.");
            exit(atm);
        }
        else {
            // Do withdrawal
            CashWithdrawalProcessor cashWithdrawalProcessor = new TwoThousandWithdrawalProcessor(
                                                                  new FiveHundredWithdrawalProcessor(
                                                                      new OneHundredWithdrawalProcessor(null)));
            cashWithdrawalProcessor.withdraw(atm, amountToWithdraw);
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
