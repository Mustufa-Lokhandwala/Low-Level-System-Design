package model.expense;

import java.util.List;

import model.ExpenseMetaData;
import model.split.Split;

public abstract class Expense {

	private double amount;
	private String paidBy;
	private ExpenseMetaData metaData;
	private List<Split> splits;
	
	public Expense(double amount, String paidBy, List<Split> splits, ExpenseMetaData metaData) {
		this.amount = amount;
		this.paidBy = paidBy;
		this.metaData = metaData;
		this.splits = splits;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaidBy() {
		return paidBy;
	}

	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}

	public ExpenseMetaData getMetadata() {
		return metaData;
	}

	public void setMetadata(ExpenseMetaData metaData) {
		this.metaData = metaData;
	}

	public List<Split> getSplits() {
		return splits;
	}

	public void setSplits(List<Split> splits) {
		this.splits = splits;
	}
	
	public abstract boolean validate();
}
