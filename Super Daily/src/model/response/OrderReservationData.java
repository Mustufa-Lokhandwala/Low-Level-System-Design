package model.response;

public class OrderReservationData {
	private Boolean reserved;
	private String message;
	
	public OrderReservationData(Boolean canReserve, String message) {
		this.reserved = canReserve;
		this.message = message;
	}

	@Override
	public String toString() {
		return "OrderReservationData [reserved=" + reserved + ", message=" + message + "]";
	}
}
