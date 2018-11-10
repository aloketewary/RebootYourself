package com.reboot.yourself.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import com.reboot.yourself.model.ApplicationConfiguration;

@Transactional
public class AppConfigDAO {

	@Autowired
	SessionFactory sessionFactory;

	public List<ApplicationConfiguration> getConfigList() {
		/**
		 * Selected a detached criteria so we do not need a session to run it within.
		 */
		try {
			DetachedCriteria dCriteria = DetachedCriteria.forClass(ApplicationConfiguration.class);

			/**
			 * Here we are doing an inner join with the Villain table in order to do a name
			 * comparison with the villainName passed in as a method parameter
			 */
			// DetachedCriteria configCriteria = criteria.createCriteria("configList");
			/*
			 * DetachedCriteria villainCriteria = criteria.createCriteria("enemyList");
			 * 
			 * villainCriteria.add(Restrictions.eq("villainName", villainName));
			 * 
			 * villainCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			 */

			dCriteria.addOrder(Order.asc("id"));
			/*ProjectionList projections = Projections.projectionList();
			projections.add(Projections.property("key"));
			projections.add(Projections.property("value"));
			dCriteria.setProjection(projections);*/
			@SuppressWarnings("unchecked")
			List<ApplicationConfiguration> results = dCriteria.getExecutableCriteria(sessionFactory.getCurrentSession())
					.list();
			System.out.println("Result" + results);
			return results;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
