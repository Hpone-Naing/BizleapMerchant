package com.bizleap.merchant.dao.impl;

import com.bizleap.merchant.dao.AbstractDao;
import com.bizleap.utils.ServiceUnavailableException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AbstractDaoImpl<E, I extends Serializable> implements AbstractDao<E, I>{
		
	/**
	 * @author 
	 * @since 1.0.0
	 */

		//private Class<E> entityClass;
		private static Logger logger = Logger.getLogger(AbstractDaoImpl.class);
		//private static Printer printer = new Printer(logger);
		
		protected AbstractDaoImpl(Class<E> entityClass) {
			//this.entityClass = entityClass;
		}

		@Autowired
		private SessionFactory sessionFactory;

		public Session getCurrentSession() {
			return sessionFactory.getCurrentSession();
		}     

		@Override
		@Transactional( readOnly = false)
		public void saveOrUpdate(E e) throws ServiceUnavailableException {
			try {
				Session session = getCurrentSession();
				session.saveOrUpdate(e); 
			} catch (Exception exception) {			
				logger.info("Exception when saving : " + exception);
			} finally {
			}
		}

		@Override
		public List<E> findByString(String queryString, String value) {
			List<E> entityList;
			Query query = getCurrentSession().createQuery(queryString).setParameter("dataInput", value);
			entityList = query.list();
			for (E entity : entityList)
				Hibernate.initialize(entity);
			return entityList;
		}
		
		@Override
		public void delete(E e) throws ServiceUnavailableException {
			try {
				getCurrentSession().delete(e);
			} catch (CannotCreateTransactionException exception) {
				logger.error(exception);
				throw new ServiceUnavailableException(exception);
			} catch (Exception exception) {
				logger.error(exception);
				throw new ServiceUnavailableException(exception);
			}
		}

		public boolean delete(String queryString, String Id) {
			Session session = getCurrentSession();
			Query query = session.createQuery(queryString);
			query.setParameter("Id", Id);
			query.executeUpdate();
			return true;
		}

		public List<E> getAll(String queryString) {
			List<E> entityList;
			Query query = getCurrentSession().createQuery(queryString);
			entityList = query.list();
			for (E entity : entityList) {
				Hibernate.initialize(entity);
			}
			return entityList;
		}

		@Override
		public long getCount(String queryString) {
			long count;
			Query query = getCurrentSession().createQuery(queryString);
			count = (long) query.uniqueResult();
			return count;
		}
		
		@Override
		public List<E> findByDate(String queryString, Date date) {
			List<E> entityList;
			Query query = getCurrentSession().createQuery(queryString).setParameter("dataInput", date);
			entityList = query.list();
			for (E entity : entityList)
				Hibernate.initialize(entity);
			return entityList;
		}

		@Override
		public List<E> findByDateRange(String queryString, Date startDate, Date endDate) {
			List<E> entityList;
			Query query = getCurrentSession().createQuery(queryString).setParameter("dataInput1", startDate).setParameter("dataInput2", endDate);
			entityList = query.list();
			for (E entity : entityList)
				Hibernate.initialize(entity);
			return entityList;
		}
}
