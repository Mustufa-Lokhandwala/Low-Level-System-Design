package service;

import java.util.List;

import model.ExpenseMetaData;
import model.ExpenseType;
import model.expense.EqualExpense;
import model.expense.ExactExpense;
import model.expense.Expense;
import model.expense.PercentExpense;
import model.split.PercentSplit;
import model.split.Split;

public class ExpenseService {

	public static Expense createExpense(ExpenseType expenseType, double amount, String paidBy, List<Split> splits, ExpenseMetaData metaData) {
		
		switch(expenseType) {
		 	case EXACT:
		 		return new ExactExpense(amount, paidBy, splits, metaData);
		 	
		 	case EQUAL:
		 		double amountOwedByEach = amount / splits.size();
		 		for(Split split : splits) {
		 			split.setAmount(amountOwedByEach);
		 		}
		 		return new EqualExpense(amount, paidBy, splits, metaData);
		 		
		 	case PERCENT:
		 		for(Split split : splits) {
		 			PercentSplit percentSplit = (PercentSplit) split; 
		 			split.setAmount(0.01 * percentSplit.getPercent() * amount);
		 		}
		 		return new PercentExpense(amount, paidBy, splits, metaData);
		 		
		 	default:
		 		return null;
		}
		
	}
}
