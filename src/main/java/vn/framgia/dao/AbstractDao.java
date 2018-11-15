package vn.framgia.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import vn.framgia.utils.HibernateUtils;

public abstract class AbstractDao<T> {
	private Class<T> entityClass;

	public AbstractDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	public List<T> findAll() {
		List<T> results = null;
		Session session = null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			results = session.createCriteria(entityClass).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return results;
	}
}
