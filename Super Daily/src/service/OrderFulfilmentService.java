package service;

import exception.OrderValidationException;
import model.request.OrderRequest;
import model.response.OrderReservationResponse;
import model.response.OrderValidationResponse;

public interface OrderFulfilmentService {
	/**
	* Takes an order request and checks if we can fulfill that order based
	* on various criteria mentioned in the problem
	*
	* @param orderRequest Order Request that customer is trying to order.
	* @return true if we can take this order, false if we cannot.
	*/
	OrderValidationResponse canFulfilOrder(OrderRequest orderRequest);
	
	/**
	* Reserves the items in the order request. This is usually called by client
	* after checking the above method. If an order is reserved,
	* that inventory is not available for any other order.
	*
	* @param orderRequest Order Request that customer is trying to order.
	 * @return 
	* @throws OrderValidationException if we cannot take that order.
	*/
	OrderReservationResponse reserveOrder(OrderRequest orderRequest) throws OrderValidationException;
}
