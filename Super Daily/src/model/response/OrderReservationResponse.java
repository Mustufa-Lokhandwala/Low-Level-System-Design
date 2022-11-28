package model.response;

public class OrderReservationResponse {
	private String code;
	private OrderReservationData orderReservationData;
	
	public OrderReservationResponse(String code, OrderReservationData orderReservationData) {
		this.code = code;
		this.orderReservationData = orderReservationData;
	}

	@Override
	public String toString() {
		return "OrderReservationResponse [code=" + code + ", orderReservationData=" + orderReservationData + "]";
	}
}
