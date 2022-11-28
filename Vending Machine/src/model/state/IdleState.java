package model.state;

import model.VendingMachine;

public class IdleState extends VendingMachineState {

    public void clickOnInsertCoinButton(VendingMachine vendingMachine) {
        System.out.println("Insert coin button is pressed.");
        vendingMachine.setVendingMachineState(new CoinAcceptanceState());
    }
}
