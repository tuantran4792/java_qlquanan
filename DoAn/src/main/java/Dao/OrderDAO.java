package Dao;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import POJO_entities.SoReceiptvoucher;
import Model.OrderModel;

public class OrderDAO {

	Transaction tran;
    HibernateUtil h;

	public OrderDAO() {
		h = new HibernateUtil();
		// TODO Auto-generated constructor stub
	}
	public List<SoSaleorder> getOrderList() {

		 List<SoSaleorder> ds = null;

		 Session session = HibernateUtil.getSessionFactory()

		 .openSession();

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

		 Session session = HibernateUtil.getSessionFactory().openSession();

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
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		SoSaleorder thisOrder = new SoSaleorder();
		Date now = new Date(); 

		try {
			tran = session.beginTransaction();
			//B1: create Order
			long OrderId = CreateOrder(order.saleOrder, userId, now);
			
			//B2: create OrderDetail
			CreateOrderDetail(order.orderDetail, userId, now, salOrderId);
			
			//B3: create Phieu thu ReceiptVoucher
			
			//Lay thong tin order vua tao xong
			thisOrder = getOrder(OrderId);
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
	
	private long CreateReceiptVoucher(SoReceiptvoucher receipt,long saleOrderId, int userId, Date now){
		long receiptVoucherId = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			receipt.saleOrderId = saleOrderId;
			receipt.createdDate = now;
			receipt.createdUser = userId;
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
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
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
	
	private void CreateOrderDetail(List<SoSaleorderDetail> details, int userId, Date now, long salOrderId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		tran = session.beginTransaction();
		
		int maxSize = 20;
		for ( int i=0; i< details.count; i++ ) {
			details[i].saleOrderId = saleOrderId;
			details[i].createdDate = now;
			details[i].createdUser = userId;
		    session.save(details[i]);
		    if ( i % maxSize == 0 ) { //20, same as the JDBC batch size
		        //flush a batch of inserts and release memory:
		        session.flush();
		        session.clear();
		    }
		}

		tran.commit();
		session.close();
	}
	
	public SaleOrderModel updateSaleOrder(SaleOrderModel request)
	{
		
	}
	
}
