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
		return template;
	}

	public ErrorDAO() {
		super(Error.class);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		this.template = new HibernateTemplate(this.sessionFactory);
		this.template.setCheckWriteOperations(false);
	}

}
