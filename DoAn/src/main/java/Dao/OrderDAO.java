package Dao;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.DateType;

import Model.Common;
import Untils.HibernateUtil;
import POJO_entities.SoSaleorder;
import POJO_entities.SoSaleorderDetail;
import POJO_entities.SoSaleorderReceiptvoucher;
import POJO_entities.BaseProduct;
import POJO_entities.SoReceiptvoucher;
import Model.OrderModel;
import Model.OrderTableModel;
import Model.ProductItemModel;

public class OrderDAO {

	Transaction tran;
    HibernateUtil h;
	public List<OrderTableModel> model = new ArrayList<OrderTableModel>();
	ProductDAO bllProduct;

	public OrderDAO() {
		h = new HibernateUtil();
		bllProduct = new ProductDAO();
		
		// TODO Auto-generated constructor stub
	}
	List<BaseProduct> products = new ArrayList<BaseProduct>();
	public List<OrderTableModel> Init(){
		products = bllProduct.getProducts(null, 0);
		OrderTableModel items = new OrderTableModel();
		items.setTableId(1);
		items.setItems(new ArrayList<ProductItemModel>());;
		model.add(0, items);

		return model;
	}
	public List<OrderTableModel> SetNewOrder(int newTableId){
		OrderTableModel items = new OrderTableModel();
		items.setTableId(newTableId);
		items.setItems(new ArrayList<ProductItemModel>());;
		model.add(items);
		return model;
	}
	public int SetNewOrderAndGetIndex(int newTableId){
		OrderTableModel items = new OrderTableModel();
		items.setTableId(newTableId);
		items.setItems(new ArrayList<ProductItemModel>());;
		model.add(items);
		return model.size() - 1 ;
	}
	public int GetCurentObject(int TableId){
		int thisTableIndex = -1;
		for (int i = 0; i < model.size(); i++) {
			if(TableId == model.get(i).TableId)
			{
				thisTableIndex = i;
				break;
			}
		}
		return thisTableIndex;
	} 
	public List<OrderTableModel> addOrUpdateItem(int Index, ProductItemModel item  )
	{
		//List<ProductItemModel> data = new  ArrayList<ProductItemModel>();
//		int thisTableIndex = -1;
//		thisTableIndex = GetCurentObject(TableId);
//		if(thisTableIndex == -1)
//		{
//			thisTableIndex = SetNewOrderAndGetIndex(TableId);
//		}
		for (int i = 0; i < products.size(); i++) {
			if(item.ProductId == products.get(i).getProductId())
			{
				item.Price = products.get(i).getRetailPrice();
				break;
			}
		}
		int i = 0;
		boolean hasvalue = false;
		for (i = 0; i < model.get(Index).items.size(); i++) {
			if(item.getProductId() == model.get(Index).items.get(i).ProductId)
			{
				hasvalue = true;
				break;
			}
		}
		if(hasvalue == true)
		{
			item.Qty = model.get(Index).items.get(i).getQty() + 1;
			model.get(Index).items.set(i, item);
		}
		else model.get(Index).items.add(item);


		return model;
	}
	public List<SoSaleorder> getOrderList() {

		 List<SoSaleorder> ds = null;

	     Session session = HibernateUtil.getSessionFactory().openSession();


		 try {

		 String stringQuery = "SELECT * FROM SO_SaleOrder WHERE IsDeleted =0";

		 Query query = session.createQuery(stringQuery);

		 ds = query.list();

		 } catch (HibernateException ex) {

		 //Log the exception

		 System.err.println(ex);

		 } finally {

		 session.close();

		 }

		 return ds;

	}
	
	public SoSaleorder getOrder(long OrderId)
	{
		 SoSaleorder order = new SoSaleorder();

		 Session session =  HibernateUtil.getSessionFactory().openSession();


		 try {

		 order = (SoSaleorder) session.get(SoSaleorder.class, 

		 OrderId);

		 } catch (HibernateException ex) {

		 //Log the exception

		 System.err.println(ex);

		 } finally {

		 session.close();

		 }

		 return order;
	}
	
	/*
	 * Tạo đơn hàng
	 * Lấy đơn hàng đã tạo 
	 */
	public SoSaleorder CreateSaleOrder(OrderModel order, int userId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();


		SoSaleorder thisOrder = new SoSaleorder();
		Date now = new Date(); 

		try {
			tran = session.beginTransaction();
			//B1: Tạo Order
			long OrderId = CreateOrder(order.saleOrder, userId, now);
			
			//B2: Tạo chi tiết OrderDetail
			
			//B3: Tạo phiếu thu ReceiptVoucher
			
			//Lấy thông tin Order vừa thực hiện xong
			
			tran.commit();
		} catch (HibernateException ex) {
		//Log the exception
		tran.rollback();
		System.err.println(ex);
		} finally {
		session.close();
		}
		return thisOrder;
	}
	
	private long CreateReceiptVoucher(SoReceiptvoucher receipt){
		long receiptVoucherId = 0;
		Session session = h.getSessionFactory().getCurrentSession();
		try {
			session.save(receipt);
			receiptVoucherId = receipt.getId();
		} 
		catch (HibernateException ex) {
			System.err.println(ex);
		} 
		finally {
			session.close();
		}
		return receiptVoucherId;
	}
	private long CreateOrder(SoSaleorder order, int userId, Date now){
		long orderId = 0;
		Session session = h.getSessionFactory().getCurrentSession();
		try {
		    if(order.getSaleUser() == null || order.getSaleUser() <= 0  ) order.setSaleUser(userId) ;
			if(order.getSaleDate() == null) order.setSaleDate(now);
		    
			session.save(order);
			
			orderId = order.getSaleOrderId();
		} 
		catch (HibernateException ex) {
			System.err.println(ex);
		} 
		finally {
			session.close();
		}
		return orderId;
	}
	public static String formatNumber(BigDecimal number) {
        if (number.intValue() < 1000) {
            return String.valueOf(number);
        }
        try {
            NumberFormat formatter = new DecimalFormat("###,###");
            String resp = formatter.format(number);
            resp = resp.replaceAll(",", ".");
            return resp;
        } catch (Exception e) {
            return "";
        }
    }
}
