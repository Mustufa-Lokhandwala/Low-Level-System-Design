package model.request;

import java.util.Date;
import java.util.List;

public class OrderRequest {
	String customerId; // Customer ID
	String warehouseId; // ID of Warehouse which serves the Customer
	Date deliveryDate; // Delivery Date
	List<ItemRequest> items; // Items that Customer is trying to Order
	
	public OrderRequest(String customerId, String warehouseId, Date deliveryDate, List<ItemRequest> items) {
		this.customerId = customerId;
		this.warehouseId = warehouseId;
		this.deliveryDate = deliveryDate;
		this.items = items;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public List<ItemRequest> getItems() {
		return items;
	}

	public void setItems(List<ItemRequest> items) {
		this.items = items;
	}
}
