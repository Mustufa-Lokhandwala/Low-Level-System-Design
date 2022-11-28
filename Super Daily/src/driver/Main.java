package driver;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datastore.DataStore;
import model.ItemCategory;
import model.aggregationKey.CategoryDateAggregationKey;
import model.aggregationKey.ItemDateAggregationKey;
import model.request.ItemRequest;
import model.request.OrderRequest;
import service.OrderFulfilmentService;
import service.OrderFulfilmentServiceImpl;

public class Main {

	public static void main(String[] args) throws ParseException {

		System.out.println("Welcome to SuprDaily\n");
		
		List<ItemRequest> itemRequests = new ArrayList<>();
		itemRequests.add(new ItemRequest(1, "Washington Apple (1 pc)", ItemCategory.F_N_V, 3));
		itemRequests.add(new ItemRequest(2, "Banana (0.5kg)", ItemCategory.F_N_V, 1));
		itemRequests.add(new ItemRequest(3, "Parle-G Biscuit (200g)", ItemCategory.GROCERY, 1));
		
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date date = format.parse("2022-07-25");
		
		OrderRequest orderRequest = new OrderRequest("10001", "100", date, itemRequests);
		
		ItemDateAggregationKey itemDateKey1 = new ItemDateAggregationKey(1, date);
		ItemDateAggregationKey itemDateKey2 = new ItemDateAggregationKey(2, date);
		ItemDateAggregationKey itemDateKey3 = new ItemDateAggregationKey(3, date);
		
		DataStore.itemDatewiseQuantityLimit.put(itemDateKey1, 3);
		DataStore.itemDatewiseQuantityLimit.put(itemDateKey2, 1);
		DataStore.itemDatewiseQuantityLimit.put(itemDateKey3, 1);

		CategoryDateAggregationKey categDateKey1 = new CategoryDateAggregationKey(ItemCategory.F_N_V, date);
		CategoryDateAggregationKey categDateKey2 = new CategoryDateAggregationKey(ItemCategory.GROCERY, date);
		
		DataStore.categoryDatewiseQuantityLimit.put(categDateKey1, 3);
		DataStore.categoryDatewiseQuantityLimit.put(categDateKey2, 1);
		
		OrderFulfilmentService service = new OrderFulfilmentServiceImpl();
		System.out.println(service.canFulfilOrder(orderRequest) + "\n");
		System.out.println(service.reserveOrder(orderRequest));
		
	}

}
