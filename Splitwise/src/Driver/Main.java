package Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import manager.ExpenseManager;
import model.ExpenseType;
import model.CommandType;
import model.User;
import model.split.EqualSplit;
import model.split.ExactSplit;
import model.split.PercentSplit;
import model.split.Split;

public class Main {

	public static void main(String[] args) {
		ExpenseManager expenseManager = new ExpenseManager();
		
		User user1 = new User("u1", "Mustafa", "mlokhandwala@nvidia.com", "9888983982");
		User user2 = new User("u2", "Fatema", "fatema@nvidia.com", "9888683982");
		User user3 = new User("u3", "Murtuza", "murtuza@nvidia.com", "9288983982");
		User user4 = new User("u4", "Abbas", "abbas@nvidia.com", "9848983982");
		
		expenseManager.addUser(user1);
		expenseManager.addUser(user2);
		expenseManager.addUser(user3);
		expenseManager.addUser(user4);
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			String line = scanner.nextLine();
			List<String> params = Arrays.asList(line.split(" "));

			if(params.size() == 0)
				break;
			
			CommandType commandType = CommandType.valueOf(params.get(0));
			
			switch(commandType) {
				case EXPENSE:
					String paidBy = params.get(1);
					double amount = Double.parseDouble(params.get(2));
					int noUsers = Integer.parseInt(params.get(3));
					ExpenseType expenseType = ExpenseType.valueOf(params.get(4 + noUsers));
					List<Split> splits = new ArrayList<Split>();
					
					for(int i = 0; i < noUsers; i++) {
						String owedBy = params.get(4 + i);
						switch(expenseType) {
							case EQUAL:
								splits.add(new EqualSplit(expenseManager.getUserMap().get(owedBy)));
								break;
							case EXACT:
								double amountOwed = Double.parseDouble(params.get(5 + noUsers + i));
								splits.add(new ExactSplit(expenseManager.getUserMap().get(owedBy), amountOwed));
								break;
							case PERCENT:
								double percentOwed = Double.parseDouble(params.get(5 + noUsers + i));
								splits.add(new PercentSplit(expenseManager.getUserMap().get(owedBy), percentOwed));
								break;
							default:
								break;
						}
					}
					expenseManager.addExpense(expenseType, amount, paidBy, splits, null);
					break;
					
				case SHOW:
					if(params.size() == 1)
						expenseManager.showBalances();
					else
						expenseManager.showBalance(params.get(1));
					break;
					
				default:
					break;	
			}
		
		}
	}

}
