package model.state;

import model.Coin;
import model.VendingMachine;

import static model.Coin.*;

public class CoinAcceptanceState extends VendingMachineState {

    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Accepted the coin: " + coin.name());

        switch (coin) {
            case TWO_RUPEE:
                vendingMachine.setCurrUserTwoCoins(1 + vendingMachine.getCurrUserTwoCoins());
                break;
            case FIVE_RUPEE:
                vendingMachine.setCurrUserFiveCoins(1 + vendingMachine.getCurrUserFiveCoins());
                break;
            case TEN_RUPEE:
                vendingMachine.setCurrUserTenCoins(1 + vendingMachine.getCurrUserTenCoins());
                break;
            default:
                break;
        }
    }

    public void clickOnSelectProductButton(VendingMachine vendingMachine) {
        System.out.println("Select product button is pressed");
        vendingMachine.setVendingMachineState(new SelectProductState());
    }
}
