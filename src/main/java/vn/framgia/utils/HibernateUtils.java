package vn.framgia.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	private static SessionFactory sessionFactory = null;

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties())
					.build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = buildSessionFactory();
		}
		return sessionFactory;
	}
}
