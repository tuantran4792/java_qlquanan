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

		 Session session = h.getSessionFactory()

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

		 Session session = h.getSessionFactory().openSession();

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
		Session session = h.getSessionFactory().getCurrentSession();

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
	
}
