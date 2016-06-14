package Model;

import java.util.ArrayList;
import java.util.List;

public class OrderTableModel {
	public int TableId;
	
	public List<ProductItemModel> items;
	
	public int getTableId() {
		return TableId;
	}
	public void setTableId(int tableId) {
		TableId = tableId;
	}
	public List<ProductItemModel> getItems() {
		return items;
	}
	public void setItems(List<ProductItemModel> items) {
		this.items = items;
	}
	
}
