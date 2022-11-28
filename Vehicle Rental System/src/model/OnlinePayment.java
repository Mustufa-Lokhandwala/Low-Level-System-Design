package model;

public class OnlinePayment implements Payment {

	@Override
	public void payBill(Bill bill) {
		double amount = bill.computeBillAmount();
		
		// do online payment processing and update the bill status.
		bill.setIsPaid(true);
		
		System.out.println("Bill paid for Rs " + amount + " via online method.");
	}
}
