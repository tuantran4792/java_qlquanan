package Dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import POJO_entities.SystemUserAccount;
import Untils.HibernateUtil;

public class UserDAO {

	Transaction tran;
    //HibernateUtil h;
    
    public UserDAO() {
		//h = new HibernateUtil();
	}
    
    public boolean getUser(String username, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();

    	//Session session = h.getSessionFactory().openSession();
    	boolean result = false;

		 try {

		// String stringQuery = String.format( "SELECT Username, Password FROM system_user_account WHERE Username='{0}' AND Password ='{1}' AND IsDeleted = 0 AND IsActived = 1", username,password);
		 Criteria criteria = session.createCriteria(SystemUserAccount.class);
		 criteria.add(Restrictions.eq("username", username));
		 criteria.add(Restrictions.eq("password", password));
	 
		 return criteria.list().size() > 0 ? true: false;

		// Query query = session.createQuery(stringQuery);
		 
		// int data = 0;
		//  data = query.getFirstResult();
		//  if(data > 0) result = true;
		 } catch (HibernateException ex) {

		 //Log the exception

		 System.err.println(ex);

		 } finally {

		 session.close();

		 }
    	return result;
    }
	

}
