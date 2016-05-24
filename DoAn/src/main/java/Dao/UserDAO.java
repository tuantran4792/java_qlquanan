package Dao;
import POJO_entities.SystemUserAccount;
import POJO_entities.SystemGroup;
import POJO_entities.SystemGroupRolelist;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Untils.HibernateUtil;

public class UserDAO {

	Transaction tran;
    HibernateUtil h;
    
    public UserDAO() {
		h = new HibernateUtil();
	}
    
    public SystemUserAccount getUser(String username, String password){
    	
    	SystemUserAccount account = new SystemUserAccount();
    	Session session = HibernateUtil.getSessionFactory().openSession();

    			/* try {

    				 account = (SystemUserAccount) session.get(SystemUserAccount.class );

    			 } catch (HibernateException ex) {


    				 System.err.println(ex);

    			 } finally {

    			 session.close();

    			 }
    			 */
    	return account;
    }
	

}
