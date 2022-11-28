package model;

public class CashPayment implements Payment {

	@Override
	public void payBill(Bill bill) {
		double amount = bill.computeBillAmount();
		
		// do cash payment processing and update the bill status.
		bill.setIsPaid(true);
		
		System.out.println("Bill paid for Rs " + amount + " via cash method.");
	}
}
