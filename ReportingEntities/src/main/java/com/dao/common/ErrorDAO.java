package com.dao.common;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.dao.AbstractDAO;
import com.entity.common.Error;

public class ErrorDAO extends AbstractDAO<Error> {

	private SessionFactory sessionFactory;
	private HibernateTemplate template;

	@Override
	protected HibernateTemplate getHibernateTemplate() {
		if (template != null)
			System.out.println("template ok");
		else
			System.out.println("template null");
		return template;
	}

	public ErrorDAO() {
		super(Error.class);
		System.out.println("ErrorDAO: Constructor");
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
		if (sessionFactory != null)
			System.out.println("sessionFactory ok");
		else
			System.out.println("sessionFactory null");
		
		this.template = new HibernateTemplate(this.sessionFactory);
		this.template.setCheckWriteOperations(false);
	}

}
