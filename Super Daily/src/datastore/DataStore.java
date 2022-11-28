package datastore;

import java.util.HashMap;
import java.util.Map;

import model.aggregationKey.CategoryDateAggregationKey;
import model.aggregationKey.ItemDateAggregationKey;

public class DataStore {
	public static Map<ItemDateAggregationKey, Integer> itemDatewiseQuantityLimit = new HashMap<>();
	public static Map<CategoryDateAggregationKey, Integer> categoryDatewiseQuantityLimit = new HashMap<>();
}
