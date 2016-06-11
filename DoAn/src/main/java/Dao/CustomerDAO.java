package Dao;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.DateType;

import Untils.HibernateUtil;

import POJO_entities.CusCustomers;
public class CustomerDAO {

	Transaction tran;
    HibernateUtil h;
    
	public CustomerDAO() {
		h = new HibernateUtil();
		// TODO Auto-generated constructor stub
	}
	public CusCustomers getCustomer(long customerId)
	{
		CusCustomers customer = new CusCustomers();

		 Session session = h.getSessionFactory().openSession();

		 try {

			 customer = (CusCustomers) session.get(CusCustomers.class, 

		 customerId);

		 } catch (HibernateException ex) {

		 //Log the exception

		 System.err.println(ex);

		 } finally {

		 session.close();

		 }

		 return customer;
	}
	
	public long createCustomer(CusCustomers customer)
	{
		long result = 0;
		Session session = h.getSessionFactory().getCurrentSession();
		try {
		    if(customer.getCustomerName() == null || customer.getCreatedUser() <= 0  ) 
		    System.err.println("Co loi xay ra, xin kiem tra lai");
		    
			session.save(customer);
			
			result = customer.getId();
		} 
		catch (HibernateException ex) {
			System.err.println(ex);
		} 
		finally {
			session.close();
		}
		return result;
	}
	public List<CusCustomers> Search(String keyword)
	{
		return new ArrayList<CusCustomers>();
	}
}
