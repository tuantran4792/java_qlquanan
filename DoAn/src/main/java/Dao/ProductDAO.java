package Dao;

import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import POJO_entities.BaseProduct;
import Model.Common;
import Untils.HibernateUtil;

public class ProductDAO {

	Transaction tran;
	Common cm;
    public ProductDAO() {
    	cm = new Common();
		//h = new HibernateUtil();
	}
    
    public List<BaseProduct> getProducts(String keyword, int CategoryID)
	{
		List<BaseProduct> result = new ArrayList<BaseProduct>();
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			Criteria criteria = session.createCriteria(BaseProduct.class);
			criteria.add(Restrictions.sqlRestriction("isDeleted = 0"));
			criteria.add(Restrictions.sqlRestriction("isActived = 1"));
			if(keyword != null && !keyword.isEmpty())
			{
				criteria.add(Restrictions.like("barCode", "%" + keyword +"%"));
			}
			if(CategoryID > 0)
				criteria.add(Restrictions.eq("categoryID", CategoryID));
		    if(criteria.list().size() > 0)
		    	result = criteria.list();
		    }
		catch (HibernateException ex) {
		System.err.println(ex);
		//Log the exception
		}
		return result;
	}
	public BaseProduct getProduct(long ProductId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		BaseProduct result = new BaseProduct();
		try{
			Criteria criteria = session.createCriteria(BaseProduct.class);
			criteria.add(Restrictions.sqlRestriction("isDeleted = 0"));
			criteria.add(Restrictions.sqlRestriction("isActived = 1"));
			criteria.add(Restrictions.eq("ProductId", ProductId));
			
		}	
		catch (HibernateException ex) {
			System.err.println(ex);
		//Log the exception
		}
		return result;
	}
	public Boolean updateProduct (BaseProduct item, int UserId)
	{
		Boolean result = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
	      try{
	    	 transaction = session.beginTransaction();
	    	 BaseProduct product = (BaseProduct)session.get(BaseProduct.class, item.getProductId()); 
	    	 product.setBarCode(item.getBarCode());
	    	 product.setCategoryId(item.getCategoryId());
	    	 product.setRetailPrice(item.getRetailPrice());
	    	 product.setProductName(item.getProductName());
	    	 product.setIsActived(item.isIsActived());
	    	 product.setUpdatedUser(UserId);
	    	 product.setUpdatedDate(new Date());
	    	 session.update(product); 
	         transaction.commit();
	         result = true;
	      }catch (HibernateException e) {
	         if (transaction!= null) transaction.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return result;
	}
	public Integer addProduct(BaseProduct item, int UserId){
        int ProductId = 0;
		Session session = HibernateUtil.getSessionFactory().openSession();

		if(item.getBarCode().isEmpty())
		{
			Long Id = (Long) session.createQuery("from Base_Product ORDER BY ProductId DESC")
	                .setMaxResults(1)
	                .uniqueResult();
			if(Id < 0 )Id = Long.valueOf(1); 
			String newBarcode = cm.setPrefix(4,Id);
			item.setBarCode(newBarcode);
		}
		Transaction transaction = null;
	      try{
	    	 transaction = session.beginTransaction();
	    	 
	    	 item.setCreatedUser(UserId);
	    	 item.setCreatedDate(new Date());
	         ProductId = (Integer) session.save(item); 
	         transaction.commit();
	      }catch (HibernateException e) {
	         if (transaction!= null) transaction.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return ProductId;
	}
	
	public Boolean deleteProduct(Long productId, int UserId)
	{
		Boolean result = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
	      try{
	    	 transaction = session.beginTransaction();
	    	 BaseProduct product = (BaseProduct)session.get(BaseProduct.class, productId); 
	    	 product.setIsDeleted(true);
	    	 product.setDeletedDate(new Date());
	    	 product.setDeletedUser(UserId);
	    	
	    	 session.update(product); 
	         transaction.commit();
	         result = true;
	      }catch (HibernateException e) {
	         if (transaction!= null) transaction.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return result;
	}
	
}
