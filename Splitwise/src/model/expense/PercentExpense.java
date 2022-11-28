package model.expense;

import java.util.List;

import model.ExpenseMetaData;
import model.split.PercentSplit;
import model.split.Split;

public class PercentExpense extends Expense {

	public PercentExpense(double amount, String paidBy, List<Split> splits, ExpenseMetaData metaData) {
		super(amount, paidBy, splits, metaData);
	}

	@Override
	public boolean validate() {
		
		double totalPercent = 0;
		
		for(Split split : getSplits()) {
			if(!(split instanceof PercentSplit))
				return false;
			
			PercentSplit percentSplit = (PercentSplit)split;
			totalPercent += percentSplit.getPercent();
		}
		
		return totalPercent == 100;
	}
	
}
