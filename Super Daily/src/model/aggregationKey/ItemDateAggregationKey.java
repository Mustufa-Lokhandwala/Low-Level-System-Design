package model.aggregationKey;

import java.util.Date;
import java.util.Objects;

public class ItemDateAggregationKey {
	private Integer itemId;
	private Date date;
	
	public ItemDateAggregationKey(Integer itemId, Date date) {
		this.itemId = itemId;
		this.date = date;
	}

	@Override
	public String toString() {
		return "ItemDateAggregationKey [itemId=" + itemId + ", date=" + date + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(date, itemId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDateAggregationKey other = (ItemDateAggregationKey) obj;
		return Objects.equals(date, other.date) && Objects.equals(itemId, other.itemId);
	}
}
