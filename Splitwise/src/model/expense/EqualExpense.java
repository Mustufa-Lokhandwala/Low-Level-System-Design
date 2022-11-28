package model.expense;

import java.util.List;

import model.ExpenseMetaData;
import model.ExpenseType;
import model.split.EqualSplit;
import model.split.Split;

public class EqualExpense extends Expense {	
	
	public EqualExpense(double amount, String paidBy, List<Split> splits, ExpenseMetaData metaData) {
		super(amount, paidBy, splits, metaData);
	}
	
	public boolean validate() {
		for(Split split : getSplits()) {
			if(!(split instanceof EqualSplit))
				return false;
		}
		return true;
	}
}
