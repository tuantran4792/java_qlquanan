package Dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import Model.User.UserModel;
import POJO_entities.SystemUser;
import POJO_entities.SystemUserAccount;
import Untils.HibernateUtil;
import java.security.MessageDigest;
import Model.User.CreateUserModel;
import POJO_entities.SystemUserAccount;

public class UserDAO {

	Transaction tran;
    //HibernateUtil h;
    
    public UserDAO() {
		//h = new HibernateUtil();
	}
    
    public UserModel getUser(String username, String password)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();

    	//Session session = h.getSessionFactory().openSession();
        UserModel result = new UserModel();
		try {
		// String stringQuery = String.format( "SELECT Username, Password FROM system_user_account WHERE Username='{0}' AND Password ='{1}' AND IsDeleted = 0 AND IsActived = 1", username,password);
		 Criteria criteria = session.createCriteria(SystemUserAccount.class);
		 String hashPassword;
			try {
				hashPassword = toMD5(password);
				criteria.add(Restrictions.eq("password", hashPassword));
	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 criteria.add(Restrictions.eq("username", username));
		 
		 if(criteria.list().size() > 0)
		 {	SystemUserAccount temp = (SystemUserAccount) criteria.list().get(0);
		 	result.Username = temp.getUsername();
		 	result.Paswword = temp.getPassword();
		 	result.setGroupId(temp.getGroupId());
		 }	
		 } catch (HibernateException ex) {

		 //Log the exception

		 System.err.println(ex);

		 } finally {

		 session.close();

		 }
    	return result;
    }
    private String toMD5(String password)throws Exception
    {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	return hexString.toString();
    }
    
    public boolean CreateUser(CreateUserModel request, int createUser){
    	
    	boolean result = false;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			 Transaction transaction = null;

			 try {

			 transaction = session.beginTransaction();
			 SystemUserAccount model = new SystemUserAccount();
			 model.setSystemUsers((Set<SystemUser>) request.userInfo);
			
			 session.save(model);
			 transaction.commit();

			 } catch (HibernateException ex) {

			 //Log the exception

			 transaction.rollback();

			 System.err.println(ex);

			 } finally {

			 session.close();

			 }

			 return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;
    }

}

