package model;

import manager.InventoryManager;
import model.state.IdleState;
import model.state.VendingMachineState;

public class VendingMachine {
    private VendingMachineState vendingMachineState;
    private InventoryManager inventoryManager;

    private int overallTenCoins;
    private int overallFiveCoins;
    private int overallTwoCoins;

    private int currUserTenCoins;
    private int currUserFiveCoins;
    private int currUserTwoCoins;

    private static VendingMachine vendingMachineObj;

    public static VendingMachine getVendingMachineObject(InventoryManager inventoryManager) {
        if(vendingMachineObj == null) {
            vendingMachineObj = new VendingMachine();
            vendingMachineObj.setVendingMachineState(new IdleState());
            vendingMachineObj.setInventoryManager(inventoryManager);
            vendingMachineObj.setOverallTenCoins(0);
            vendingMachineObj.setOverallFiveCoins(0);
            vendingMachineObj.setOverallTwoCoins(0);
            vendingMachineObj.setCurrUserTenCoins(0);
            vendingMachineObj.setCurrUserFiveCoins(0);
            vendingMachineObj.setCurrUserTwoCoins(0);
        }
        return vendingMachineObj;
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public void setInventoryManager(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public int getOverallTenCoins() {
        return overallTenCoins;
    }

    public void setOverallTenCoins(int overallTenCoins) {
        this.overallTenCoins = overallTenCoins;
    }

    public int getOverallFiveCoins() {
        return overallFiveCoins;
    }

    public void setOverallFiveCoins(int overallFiveCoins) {
        this.overallFiveCoins = overallFiveCoins;
    }

    public int getOverallTwoCoins() {
        return overallTwoCoins;
    }

    public void setOverallTwoCoins(int overallTwoCoins) {
        this.overallTwoCoins = overallTwoCoins;
    }

    public int getCurrUserTenCoins() {
        return currUserTenCoins;
    }

    public void setCurrUserTenCoins(int currUserTenCoins) {
        this.currUserTenCoins = currUserTenCoins;
    }

    public int getCurrUserFiveCoins() {
        return currUserFiveCoins;
    }

    public void setCurrUserFiveCoins(int currUserFiveCoins) {
        this.currUserFiveCoins = currUserFiveCoins;
    }

    public int getCurrUserTwoCoins() {
        return currUserTwoCoins;
    }

    public void setCurrUserTwoCoins(int currUserTwoCoins) {
        this.currUserTwoCoins = currUserTwoCoins;
    }

    public void resetCurrentUserCoins() {
        setCurrUserTenCoins(0);
        setCurrUserFiveCoins(0);
        setCurrUserTwoCoins(0);
    }
}
