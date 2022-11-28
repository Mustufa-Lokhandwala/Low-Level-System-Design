package model.prcoessor;

import model.ATM;

public class OneHundredWithdrawalProcessor extends CashWithdrawalProcessor {

    public OneHundredWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
        super(nextCashWithdrawalProcessor);
    }

    @Override
    public void withdraw(ATM atm, int amountToWithdraw) {
        int neededNotes = amountToWithdraw / 100;
        int availableNotes = atm.getNoOfOneHundredNotes();
        int balance = 0;

        if(availableNotes > neededNotes) {
            atm.deductOneHundredNotes(neededNotes);
            balance = amountToWithdraw - 100 * neededNotes;
        }
        else {
            atm.deductOneHundredNotes(availableNotes);
            balance = amountToWithdraw - 100 * availableNotes;
        }

        if(balance > 0) {
            super.withdraw(atm, balance);
        }
    }
}
