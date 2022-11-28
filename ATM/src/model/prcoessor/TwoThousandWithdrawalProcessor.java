package model.prcoessor;

import model.ATM;

public class TwoThousandWithdrawalProcessor extends CashWithdrawalProcessor {

    public TwoThousandWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
        super(nextCashWithdrawalProcessor);
    }

    public void withdraw(ATM atm, int amountToWithdraw) {
        int neededNotes = amountToWithdraw / 2000;
        int availableNotes = atm.getNoOfTwoThousandNotes();
        int balance = 0;

        if(availableNotes > neededNotes) {
            atm.deductTwoThousandNotes(neededNotes);
            balance = amountToWithdraw - 2000 * neededNotes;
        }
        else {
            atm.deductTwoThousandNotes(availableNotes);
            balance = amountToWithdraw - 2000 * availableNotes;
        }

        if(balance > 0)
            super.withdraw(atm, balance);
    }
}
