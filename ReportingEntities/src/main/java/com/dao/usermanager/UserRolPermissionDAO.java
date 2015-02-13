package com.dao.usermanager;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.dao.AbstractDAO;
import com.entity.usermanager.UserRolPermission;

public class UserRolPermissionDAO extends AbstractDAO<UserRolPermission> {

	private SessionFactory sessionFactory;
	private HibernateTemplate template;
	
	@Override
	protected HibernateTemplate getHibernateTemplate() {
		return template;
	}

	public UserRolPermissionDAO() {
		super(UserRolPermission.class);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		this.template = new HibernateTemplate(this.sessionFactory);
		this.template.setCheckWriteOperations(false);
	}

}
