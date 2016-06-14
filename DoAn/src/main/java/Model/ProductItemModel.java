package Model;

import java.math.BigDecimal;

public class ProductItemModel {
	public Long ProductId;
	public int Qty;
	public String Name;
	public BigDecimal Price;
	public BigDecimal getPrice() {
		return Price;
	}
	public void setPrice(BigDecimal price) {
		Price = price;
	}
	public Long getProductId() {
		return ProductId;
	}
	public void setProductId(Long productId) {
		ProductId = productId;
	}
	public int getQty() {
		return Qty;
	}
	public void setQty(int qty) {
		Qty = qty;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
}
