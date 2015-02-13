package com.dao.loader;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.dao.AbstractDAO;
import com.entity.loader.LoadError;

public class LoadErrorDAO extends AbstractDAO<LoadError>{

	private SessionFactory sessionFactory;
	private HibernateTemplate template;
	
	@Override
	protected HibernateTemplate getHibernateTemplate() {
		return template;
	}

	public LoadErrorDAO() {
		super(LoadError.class);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		this.template = new HibernateTemplate(this.sessionFactory);
		this.template.setCheckWriteOperations(false);
	}
}
