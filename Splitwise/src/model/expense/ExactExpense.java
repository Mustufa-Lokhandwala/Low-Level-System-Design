package model.expense;

import java.util.List;

import model.ExpenseMetaData;
import model.split.ExactSplit;
import model.split.Split;

public class ExactExpense extends Expense {

	public ExactExpense(double amount, String paidBy, List<Split> splits, ExpenseMetaData metaData) {
		super(amount, paidBy, splits, metaData);
	}

	@Override
	public boolean validate() {
		
		double sumSplitAmount = 0;
		
		for(Split split : getSplits()) {
			if(!(split instanceof ExactSplit)) 
				return false;
			sumSplitAmount += split.getAmount();
		}
		
		return sumSplitAmount == getAmount();
	}

}