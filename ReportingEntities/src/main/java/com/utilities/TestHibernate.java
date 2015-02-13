package com.utilities;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.common.ErrorDAO;
import com.entity.common.Error;
import com.utilities.hibernate.VersionAuditor;

public class TestHibernate {
//	private static SessionFactory sessionFactory;
//	private static ServiceRegistry serviceRegistry;
//	private static Configuration configuration;

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		try {
			// File hibernateFile = new File ("hibernate.cfg.xml");
			// configuration = new Configuration();
			// configuration.configure(hibernateFile);
			// serviceRegistry = new StandardServiceRegistryBuilder()
			// .applySettings(configuration.getProperties()).build();
			// sessionFactory =
			// configuration.buildSessionFactory(serviceRegistry);

			ApplicationContext aplicationContext = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			

			Error error = new Error();
			error.setErrorName("ejemplo1");
			error.setErrorText("ejemplo 1 e e e e ");
			error.setErrorType("tyoe1");
			error.setErrorLevel("COMPANY");
			error.setAuditor(new VersionAuditor("admin"));

			ErrorDAO errorDAO = (ErrorDAO)aplicationContext.getBean("errorDao");
	
			errorDAO.create(error);

		} catch (Throwable ex) {
			System.err
					.println("Error creando sesionfactory " + ex.getMessage());
			throw new ExceptionInInitializerError(ex);
		}
	}

}
