package driver;

import model.*;

public class Main {
    public static void main(String[] args) {
        User user = new User("1", "Mustafa");
        BankAccount bankAccount = new BankAccount(user, 5000);
        Card card = new Card(1, 005, "10/11/2025", "Mustafa", 457001, bankAccount);

        ATM atm = ATM.getATMObject();
        atm.addNotesToMachine(2, 2, 3);
        atm.printATM();

        atm.getAtmState().insertCard(atm, card);
        atm.getAtmState().authenticateCard(atm, card, 457001);
        atm.getAtmState().selectOperation(atm, card, TransactionType.CASH_WITHDRAWAL);
        atm.getAtmState().withdrawCash(atm, card, 2800);

        atm.printATM();
    }

}