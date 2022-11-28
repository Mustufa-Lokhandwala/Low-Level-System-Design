package model.state;

import model.Item;
import model.VendingMachine;

public class SelectProductState extends VendingMachineState {

    public void selectProduct(VendingMachine vendingMachine, int code) {
        Item item = vendingMachine.getInventoryManager().getItem(code);
        if(item == null) {
            System.out.println("Incorrect code entered. Please enter correct code.");
            return ;
        }

        System.out.println("Selected code " + code + " for item: " + item.getItemType());
        int priceOfSelectedItem = vendingMachine.getInventoryManager().getItem(code).getPrice();

        int amountPaid = 0;
        amountPaid += 10 * vendingMachine.getCurrUserTenCoins();
        amountPaid += 5 * vendingMachine.getCurrUserFiveCoins();
        amountPaid += 2 * vendingMachine.getCurrUserTwoCoins();

        if(amountPaid < priceOfSelectedItem) {
            System.out.println("Amount paid for selected item is insufficient.");
            refundFullMoney(vendingMachine);
        }
        else if (amountPaid == priceOfSelectedItem) {
            System.out.println("You paid the exact amount as needed for selected item.");

            vendingMachine.setOverallTenCoins(vendingMachine.getCurrUserTenCoins()
                                              + vendingMachine.getOverallTenCoins());
            vendingMachine.setOverallFiveCoins(vendingMachine.getCurrUserFiveCoins()
                                               + vendingMachine.getOverallFiveCoins());
            vendingMachine.setOverallTwoCoins(vendingMachine.getCurrUserTwoCoins()
                                              + vendingMachine.getOverallTwoCoins());

            vendingMachine.resetCurrentUserCoins();
            vendingMachine.setVendingMachineState(new DispenseProductState());
        }
        else {
            int balance = amountPaid - priceOfSelectedItem;
            int availableTenCoins = vendingMachine.getOverallTenCoins() + vendingMachine.getCurrUserTenCoins();
            int availableFiveCoins = vendingMachine.getOverallFiveCoins() + vendingMachine.getCurrUserFiveCoins();
            int availableTwoCoins = vendingMachine.getOverallTwoCoins() + vendingMachine.getCurrUserTwoCoins();

            int neededTenCoins = balance / 10;
            if(availableTenCoins >= neededTenCoins)
                balance = balance - neededTenCoins * 10;

            int neededFiveCoins = balance / 5;
            if (availableFiveCoins >= neededFiveCoins)
                balance = balance - neededFiveCoins * 5;

            int neededTwoCoins = balance / 2;
            if (availableTwoCoins >= neededTwoCoins)
                balance = balance - neededTwoCoins * 2;

            if(balance == 0) {
                System.out.println("Please collect change.");
                System.out.println("No. of returned ten coins: " + neededTenCoins);
                System.out.println("No. of returned five coins: " + neededFiveCoins);
                System.out.println("No. of returned two coins: " + neededTwoCoins);

                vendingMachine.setOverallTenCoins(availableTenCoins - neededTenCoins);
                vendingMachine.setOverallFiveCoins(availableFiveCoins - neededFiveCoins);
                vendingMachine.setOverallTwoCoins(availableTwoCoins - neededTwoCoins);

                vendingMachine.resetCurrentUserCoins();
                vendingMachine.setVendingMachineState(new DispenseProductState());
            } else {
                System.out.println("No change available.");
                refundFullMoney(vendingMachine);
            }
        }
    }

    private void refundFullMoney(VendingMachine vendingMachine) {
        System.out.println("Refunding full amount. Please collect !!");
        vendingMachine.resetCurrentUserCoins();
        vendingMachine.setVendingMachineState(new IdleState());
    }
}
