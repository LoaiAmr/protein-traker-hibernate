package com.datagearbi.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.datagearbi.hibernate.model.AuditInterceptors;

public class HibernateUtitlities {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	static {

		try {
			Configuration configuration = new Configuration().setInterceptor(new AuditInterceptors()).configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
					.buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		} catch (HibernateException exception) {
			System.out.println("Problem when creating Session Factory");
		}

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
