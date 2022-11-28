package manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.ExpenseMetaData;
import model.ExpenseType;
import model.User;
import model.expense.Expense;
import model.split.Split;
import service.ExpenseService;

public class ExpenseManager {
	
	private List<Expense> expenses;
	private Map<String, User> userMap;
	private Map<String, Map<String, Double>> balanceSheet;
	
	public ExpenseManager() {
		this.expenses = new ArrayList<Expense>();
		this.userMap = new HashMap<String, User>();
		this.balanceSheet = new HashMap<String, Map<String, Double>>();
	}
	
	public void addUser(User user) {
		userMap.put(user.getId(), user);
		balanceSheet.put(user.getId(), new HashMap<String, Double>());
	}
	
	public void addExpense(ExpenseType expenseType, double amount, String paidBy, List<Split> splits, ExpenseMetaData metaData) {
		Expense expense = ExpenseService.createExpense(expenseType, amount, paidBy, splits, metaData);
		
		if(!expense.validate()) {
			System.out.println("Expense created is invalid. Please Check.");
			return ;
		}
		
		expenses.add(expense);
		
		for(Split split : splits) {
			String owedBy = split.getUser().getId();			
			
			if(!balanceSheet.get(paidBy).containsKey(owedBy))
				balanceSheet.get(paidBy).put(owedBy, 0.0);
			
			double currAmount = balanceSheet.get(paidBy).get(owedBy);
			balanceSheet.get(paidBy).put(owedBy, currAmount + split.getAmount());
		
			if(!balanceSheet.get(owedBy).containsKey(paidBy))
				balanceSheet.get(owedBy).put(paidBy, 0.0);
			
			currAmount = balanceSheet.get(owedBy).get(paidBy);
			balanceSheet.get(owedBy).put(paidBy, currAmount - split.getAmount());
		}
	}
	
	public void showBalance(String userID) {
		boolean isEmpty = true;
		for(Entry<String, Double> userBalances : balanceSheet.get(userID).entrySet()) {
			if(userBalances.getValue() != 0) {
				printBalance(userID, userBalances.getKey(), userBalances.getValue());
				isEmpty = false;
			}
		}
		
		if(isEmpty)
			System.out.println("No Balance");	
	}

	public void showBalances() {
		boolean isEmpty = true;
		for(Entry<String, Map<String, Double>> allBalances : balanceSheet.entrySet()) {
			for(Entry<String, Double> userBalances : allBalances.getValue().entrySet()) {
				if(userBalances.getValue() > 0) {
					isEmpty = false;
					printBalance(allBalances.getKey(), userBalances.getKey(), userBalances.getValue());
				}
			}
		}
		
		if(isEmpty)
			System.out.println("No Balance");	
	}

	private void printBalance(String user1, String user2, Double value) {
		if(value > 0)
			System.out.println(user2 + " owes " + user1 + ": " + value);
		else
			System.out.println(user1 + " owes " + user2 + ": " + Math.abs(value));	
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public Map<String, User> getUserMap() {
		return userMap;
	}

	public Map<String, Map<String, Double>> getBalanceSheet() {
		return balanceSheet;
	}
}
