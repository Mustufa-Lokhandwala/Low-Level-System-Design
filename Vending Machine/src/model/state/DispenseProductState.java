package model.state;

import model.Item;
import model.VendingMachine;

public class DispenseProductState extends VendingMachineState {

    public void dispenseProduct(VendingMachine vendingMachine, int code) {
        Item item = vendingMachine.getInventoryManager().getItem(code);
        System.out.println("Item " + item.getItemType() + " is dispensed. Please collect !!");
        
        vendingMachine.getInventoryManager().updateSoldOutItem(code);
        vendingMachine.setVendingMachineState(new IdleState());
    }

}
