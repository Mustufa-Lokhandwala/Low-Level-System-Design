package model.request;

import model.ItemCategory;

public class ItemRequest {
	Integer itemId;
	String itemName;
	ItemCategory itemCategory; // Category that the items belongs to.
	Integer quantity; // Quantity trying to be ordered.
	
	public ItemRequest(Integer itemId, String itemName, ItemCategory itemCategory, Integer quantity) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.quantity = quantity;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
