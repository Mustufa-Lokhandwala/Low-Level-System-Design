package model.prcoessor;

import model.ATM;

public class FiveHundredWithdrawalProcessor extends CashWithdrawalProcessor {

    public FiveHundredWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
        super(nextCashWithdrawalProcessor);
    }

    @Override
    public void withdraw(ATM atm, int amountToWithdraw) {
        int neededNotes = amountToWithdraw / 500;
        int availableNotes = atm.getNoOfFiveHundredNotes();
        int balance = 0;

        if(availableNotes > neededNotes) {
            atm.deductFiveHundredNotes(neededNotes);
            balance = amountToWithdraw - 500 * neededNotes;
        }
        else {
            atm.deductFiveHundredNotes(availableNotes);
            balance = amountToWithdraw - 500 * availableNotes;
        }

        if(balance > 0)
            super.withdraw(atm, balance);
    }
}
