package service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import datastore.DataStore;
import exception.OrderValidationException;
import model.ItemCategory;
import model.aggregationKey.CategoryDateAggregationKey;
import model.aggregationKey.ItemDateAggregationKey;
import model.request.ItemRequest;
import model.request.OrderRequest;
import model.response.OrderReservationData;
import model.response.OrderReservationResponse;
import model.response.OrderValidationResponse;

public class OrderFulfilmentServiceImpl implements OrderFulfilmentService {

	private static final String SUCCESS = "SUCCESS";
	private static final String ERROR_MSG = "Insufficient quantities!";
	
	@Override
	public OrderValidationResponse canFulfilOrder(OrderRequest orderRequest) {

		Date deliveryDate = orderRequest.getDeliveryDate();
		Map<ItemCategory, Integer> requestedCategoryQtyMap = new HashMap<>();
		
		try { 
			for(ItemRequest itemRequest : orderRequest.getItems()) {
				Integer itemId = itemRequest.getItemId();
				ItemCategory itemCategory = itemRequest.getItemCategory();
				Integer requestQty = itemRequest.getQuantity();
				
				validateItemAvailability(itemId, deliveryDate, requestQty);
				
				if(!requestedCategoryQtyMap.containsKey(itemCategory))
					requestedCategoryQtyMap.put(itemCategory, requestQty);
				else
					requestedCategoryQtyMap.put(itemCategory, requestQty + requestedCategoryQtyMap.get(itemCategory));
			}
			
			validateCategoryLimit(requestedCategoryQtyMap, deliveryDate);
		} catch (OrderValidationException e) {
			System.out.println(e);
			return new OrderValidationResponse(false); 
		}
		return new OrderValidationResponse(true);
	}

	@Override
	public OrderReservationResponse reserveOrder(OrderRequest orderRequest) {
		if(!canFulfilOrder(orderRequest).getCanFulfill())
			return getOrderReservationResponse(false);
		
		Date deliveryDate = orderRequest.getDeliveryDate();
		for(ItemRequest itemRequest : orderRequest.getItems()) {
			Integer itemId = itemRequest.getItemId();
			ItemCategory itemCategory = itemRequest.getItemCategory();
			Integer requestQty = itemRequest.getQuantity();
			
			updateItemDatewiseQuantityLimit(itemId, deliveryDate, requestQty);
			updateCategoryDatewiseQuantityLimit(itemCategory, deliveryDate, requestQty);
		}
		
		return getOrderReservationResponse(true);
	}

	private void validateItemAvailability(Integer itemId, Date deliveryDate, Integer requestQty) throws OrderValidationException {
		ItemDateAggregationKey key = new ItemDateAggregationKey(itemId, deliveryDate);
		Integer availableQuantity  = DataStore.itemDatewiseQuantityLimit.get(key);
		if(availableQuantity < requestQty) {
			String errorMsg = String.format("Requested quantity (%s) exceeds the available quantity (%s) for item %s", 
											requestQty, availableQuantity, itemId);
			throw new OrderValidationException(errorMsg);
		}
	}

	private void validateCategoryLimit(Map<ItemCategory, Integer> requestedCategoryQtyMap, Date deliveryDate) throws OrderValidationException {
		Map<CategoryDateAggregationKey, Integer> availableCategoryLimitMap = DataStore.categoryDatewiseQuantityLimit;
		for(Entry<ItemCategory, Integer> entry : requestedCategoryQtyMap.entrySet()) {
			CategoryDateAggregationKey key = new CategoryDateAggregationKey(entry.getKey(), deliveryDate);
			Integer availableCategoryLimit = availableCategoryLimitMap.get(key);
			Integer requestedCategoryQty = entry.getValue();
			
			if(availableCategoryLimit < requestedCategoryQty) {
				String errorMsg = String.format("Category limit exceeded for item category %s for date " + deliveryDate, entry.getKey());
				throw new OrderValidationException(errorMsg);
			}
		}	
	}

	private void updateItemDatewiseQuantityLimit(Integer itemId, Date deliveryDate, Integer requestQty) {
		ItemDateAggregationKey key = new ItemDateAggregationKey(itemId, deliveryDate);
		Integer currQty = DataStore.itemDatewiseQuantityLimit.get(key);
		
		DataStore.itemDatewiseQuantityLimit.put(key, currQty - requestQty);
	}
	
	private void updateCategoryDatewiseQuantityLimit(ItemCategory itemCategory, Date deliveryDate, Integer requestQty) {
		CategoryDateAggregationKey key = new CategoryDateAggregationKey(itemCategory, deliveryDate);
		Integer currQty = DataStore.categoryDatewiseQuantityLimit.get(key);
	
		DataStore.categoryDatewiseQuantityLimit.put(key, currQty - requestQty);
	}
	
	private OrderReservationResponse getOrderReservationResponse(Boolean canFulfil) {
		if(canFulfil)
			return new OrderReservationResponse(SUCCESS, new OrderReservationData(true, SUCCESS));
		else
			return new OrderReservationResponse(SUCCESS, new OrderReservationData(false, ERROR_MSG));
	}
}
