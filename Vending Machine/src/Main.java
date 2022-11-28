import manager.InventoryManager;
import model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.intitialize();

        int code = 101;
        for(int i = 0; i < 9; i++) {
            if(code >= 101 && code <= 103) {
                Item item = new Item(ItemType.COKE, 10);
                inventoryManager.addItem(item, code);
            }
            else if(code >= 104 && code <= 106) {
                Item item = new Item(ItemType.BISCUIT, 5);
                inventoryManager.addItem(item, code);
            }
            else if(code >= 107 && code <= 109) {
                Item item = new Item(ItemType.PEPSI, 12);
                inventoryManager.addItem(item, code);
            }
            code++;
        }

        VendingMachine vendingMachineObject = VendingMachine.getVendingMachineObject(inventoryManager);

        displayVendingMachine(vendingMachineObject);

        vendingMachineObject.getVendingMachineState().clickOnInsertCoinButton(vendingMachineObject);
        vendingMachineObject.getVendingMachineState().insertCoin(vendingMachineObject, Coin.FIVE_RUPEE);
        vendingMachineObject.getVendingMachineState().insertCoin(vendingMachineObject, Coin.FIVE_RUPEE);
        vendingMachineObject.getVendingMachineState().clickOnSelectProductButton(vendingMachineObject);
        vendingMachineObject.getVendingMachineState().selectProduct(vendingMachineObject, 103);
        vendingMachineObject.getVendingMachineState().dispenseProduct(vendingMachineObject, 103);

        displayVendingMachine(vendingMachineObject);

        vendingMachineObject.getVendingMachineState().clickOnInsertCoinButton(vendingMachineObject);
        vendingMachineObject.getVendingMachineState().insertCoin(vendingMachineObject, Coin.TEN_RUPEE);
        vendingMachineObject.getVendingMachineState().clickOnSelectProductButton(vendingMachineObject);
        vendingMachineObject.getVendingMachineState().selectProduct(vendingMachineObject, 104);
        vendingMachineObject.getVendingMachineState().dispenseProduct(vendingMachineObject, 104);

        displayVendingMachine(vendingMachineObject);
    }

    private static void displayVendingMachine(VendingMachine machineObj) {
        System.out.println();
        System.out.println("No. of 10 coins: " + machineObj.getOverallTenCoins());
        System.out.println("No. of 5 coins: " + machineObj.getOverallFiveCoins());
        System.out.println("No. of 2 coins: " + machineObj.getOverallTwoCoins());

        List<ItemHolder> itemHolderList = machineObj.getInventoryManager().getItemHolderList();
        for(ItemHolder itemHolder : itemHolderList) {
            Item item = itemHolder.getItem();

            String itemType = (item == null) ? "no_item" : String.valueOf(item.getItemType());
            String price = (item == null) ? "no_price" : String.valueOf(item.getPrice());

            System.out.println("Code: " + itemHolder.getCode() +
                    ",  Item: " + itemType +
                    ",  Price: " + price +
                    ",  isAvailable: " + itemHolder.isAvailable());
        }
        System.out.println();
    }
}