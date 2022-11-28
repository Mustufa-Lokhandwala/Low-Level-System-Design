package model.aggregationKey;

import java.util.Date;
import java.util.Objects;

import model.ItemCategory;

public class CategoryDateAggregationKey {
	private ItemCategory itemCategory;
	private Date date;
	
	public CategoryDateAggregationKey(ItemCategory itemCategory, Date date) {
		this.itemCategory = itemCategory;
		this.date = date;
	}

	@Override
	public String toString() {
		return "CategoryDateAggregationKey [itemCategory=" + itemCategory + ", date=" + date + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(date, itemCategory);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryDateAggregationKey other = (CategoryDateAggregationKey) obj;
		return Objects.equals(date, other.date) && itemCategory == other.itemCategory;
	}

}
