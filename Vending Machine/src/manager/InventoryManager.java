package manager;

import model.Item;
import model.ItemHolder;
import model.ItemType;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<ItemHolder> itemHolderList;

    public InventoryManager() {
        itemHolderList = new ArrayList<>();
    }

    public void intitialize() {
        int code = 101;
        for(int i = 0; i < 9; i++) {
            ItemHolder itemHolder = new ItemHolder();
            itemHolder.setCode(code);
            itemHolder.setItem(null);
            itemHolder.setAvailable(false);
            itemHolderList.add(itemHolder);
            code++;
        }
    }

    public void addItem(Item item, int code) {
        for(ItemHolder itemHolder : itemHolderList) {
            if(itemHolder.getCode() == code) {
                if(itemHolder.isAvailable()) {
                    System.out.println("Can't add item in this holder as it already has one.");
                } else {
                    itemHolder.setItem(item);
                    itemHolder.setAvailable(true);
                }
            }
        }
    }

    public void updateSoldOutItem(int code) {
        for(ItemHolder itemHolder : itemHolderList) {
            if(itemHolder.getCode() == code) {
                itemHolder.setItem(null);
                itemHolder.setAvailable(false);
            }
        }
    }

    public Item getItem(int code) {
        for(ItemHolder itemHolder : itemHolderList) {
            if(itemHolder.getCode() == code)
                return itemHolder.getItem();
        }
        return null;
    }

    public List<ItemHolder> getItemHolderList() {
        return itemHolderList;
    }
}
