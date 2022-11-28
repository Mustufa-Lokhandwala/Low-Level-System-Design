package model.prcoessor;

import model.ATM;

public class CashWithdrawalProcessor {
    CashWithdrawalProcessor nextCashWithdrawalProcessor;

    public CashWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor) {
        this.nextCashWithdrawalProcessor = nextCashWithdrawalProcessor;
    }

    public void withdraw(ATM atm, int amountToWithdraw) {
        if(nextCashWithdrawalProcessor != null)
            nextCashWithdrawalProcessor.withdraw(atm, amountToWithdraw);
        else
            System.out.println("Something went wrong.");
    }

}
