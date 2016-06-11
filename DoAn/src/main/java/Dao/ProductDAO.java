package Dao;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import POJO_entities.BaseProduct;

import Untils.HibernateUtil;

public class ProductDAO {

    public ProductDAO() {
		//h = new HibernateUtil();
	}
    
    public List<BaseProduct> getProducts(String keyword, int CategoryID)
	{
		//keyword = "SP";
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
	
}
