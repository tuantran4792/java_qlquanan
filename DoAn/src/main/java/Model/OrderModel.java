package Model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import POJO_entities.SoReceiptvoucher;
import POJO_entities.SoSaleorder;
import POJO_entities.SoSaleorderDetail;
import POJO_entities.SoSaleorderReceiptvoucher;

public class OrderModel {

	  public SoSaleorder saleOrder ;
	  public SoSaleorderDetail orderDetail;
	  public SoReceiptvoucher receiptVoucher;
	public SoSaleorder getSaleOrder() {
		return saleOrder;
	}
	public void setSaleOrder(SoSaleorder saleOrder) {
		this.saleOrder = saleOrder;
	}
	public SoSaleorderDetail getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(SoSaleorderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	public SoReceiptvoucher getReceiptVoucher() {
		return receiptVoucher;
	}
	public void setReceiptVoucher(SoReceiptvoucher receiptVoucher) {
		this.receiptVoucher = receiptVoucher;
	}
}


