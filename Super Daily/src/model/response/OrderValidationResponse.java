package model.response;

public class OrderValidationResponse {
	private Boolean canFulfill;

	public OrderValidationResponse(Boolean canFulfill) {
		this.canFulfill = canFulfill;
	}

	public Boolean getCanFulfill() {
		return canFulfill;
	}

	@Override
	public String toString() {
		return "OrderValidationResponse [canFulfill=" + canFulfill + "]";
	}
}
