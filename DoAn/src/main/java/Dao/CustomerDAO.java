package Dao;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.DateType;


import Untils.HibernateUtil;
import POJO_entities.BaseProduct;
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
		CusCustomers order = new CusCustomers();

		 Session session = h.getSessionFactory().openSession();

		 try {

		 order = (CusCustomers) session.get(CusCustomers.class, 

		 customerId);

		 } catch (HibernateException ex) {

		 //Log the exception

		 System.err.println(ex);

		 } finally {

		 session.close();

		 }

		 return order;
	}
	
	public Long  createCustomer(CusCustomers customer)
	{
		Session session = h.getSessionFactory().openSession();
	      Long employeeID = null;
	      try{
	    	  tran = session.beginTransaction();
	    	  if(customer.getId() == null || customer.getId() == 0){
	    		  
	    	  }
	         employeeID = (Long) session.save(customer); 
	         tran.commit();
	      }catch (HibernateException e) {
	         if (tran!=null) tran.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return employeeID;
	}
	public List<CusCustomers> getCustomer(String keyword, int id)
	{
		List<CusCustomers> result = new ArrayList<CusCustomers>();
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			Criteria criteria = session.createCriteria(CusCustomers.class);

			if(keyword != null && !keyword.isEmpty())
			{
				criteria.add(Restrictions.eq("Barcode", keyword));
			}
			if(id > 0)
				criteria.add(Restrictions.eq("id", id));
		    if(criteria.list().size() > 0)
		    	result = criteria.list();
		    }
		catch (HibernateException ex) {
		System.err.println(ex);
		//Log the exception
		}
		return result;
	}
	
	public void  deleteCustomer(CusCustomers _cus, Integer IDUser){
		Session session = h.getSessionFactory().openSession();
	      try{
	         tran = session.beginTransaction();
	         CusCustomers cus = (CusCustomers)session.get(CusCustomers.class, _cus.getId()); 
	         cus.setIsDeleted(true);
	         java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
	         cus.setDeletedDate(sqlDate);
	         cus.setDeletedUser(IDUser);
			 session.update(cus); 
	         tran.commit();
	      }catch (HibernateException e) {
	         if (tran!=null) tran.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	         //Décription
	         //
	         //
	      }
	}
	
	public void updateCustomer(CusCustomers _cus, Integer IDUser){
	      Session session = h.getSessionFactory().openSession();
	      try{
	         tran = session.beginTransaction();
	         java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
	         _cus.setUpdatedDate(sqlDate);
	         _cus.setUpdatedUser(IDUser);
	         CusCustomers cus = (CusCustomers)session.get(CusCustomers.class, _cus.getId());
	         cus.setAddress(_cus.getAddress());
	         cus.setBirthday(_cus.getBirthday());
	         cus.setCode(_cus.getCode());
	         cus.setCustomerName(_cus.getCustomerName());
	         cus.setEmail(_cus.getEmail());
	         cus.setPhone(_cus.getPhone());
	         cus.setUpdatedDate(sqlDate);
	         cus.setUpdatedUser(IDUser);
			 session.update(cus); 
	         tran.commit();
	      }catch (HibernateException e) {
	         if (tran!=null) tran.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	         //Décription
	         //
	         //
	      }
	   }
	
	public List<CusCustomers> getAllCustomer()
	{
		List<CusCustomers> result = new ArrayList<CusCustomers>();
		Session session = h.getSessionFactory().openSession();

		try{
			tran = session.beginTransaction();
			Criteria criteria = session.createCriteria(CusCustomers.class);
			result = criteria.list();
			tran.commit();
	    }
		catch (HibernateException ex) {
		System.err.println(ex);
		//Log the exception
		}
		return result;
	} 
	
	public List searchCustomer(String txtsearch){
		List result = new ArrayList();
		Session session = h.getSessionFactory().openSession();

		try{
			tran = session.beginTransaction();
			String sqlWhere = "";
			if(txtsearch.isEmpty() == false){
				sqlWhere= " where CustomerName like '%"+txtsearch+"%' or Phone like '%"+txtsearch+"%'";
			}
			result = session.createQuery("FROM CusCustomers "+sqlWhere).list();
			tran.commit();
	    }
		catch (HibernateException ex) {
		System.err.println(ex);
		//Log the exception
		}
		return result;
	}
	
	public static String[] convertCustomerRowToArray(CusCustomers _customer){
        String[] arrayToReturn = new String[6];
      
        arrayToReturn[0] = String.valueOf(_customer.getId());
        arrayToReturn[1] = String.valueOf(_customer.getCustomerName());
        arrayToReturn[2] = String.valueOf(_customer.getBirthday());
        arrayToReturn[3] = String.valueOf(_customer.getPhone());
        arrayToReturn[4] = String.valueOf(_customer.getAddress());
        arrayToReturn[5] = String.valueOf(_customer.getEmail());
        return arrayToReturn;
    }
}
