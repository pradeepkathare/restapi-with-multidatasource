package com.restapi.hibernate;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.restapi.entites.Employee;

public class SessionFactoryService {

	//create singleton factory service for buildsession factory
	
	
	static SessionFactory factory = null;
	public static  SessionFactory buildSessionFactory() {

         Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Employee.class);
        final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
       
        factory = configuration.buildSessionFactory(builder.build());

        return factory;
	}
	
	//------------------------
	//2nd type to create session
	//--------
	private static String getPropertyFile() {
        return "/hibernate-database-multitenancy.properties";
    }
	 public  Properties getHibernateProperties() throws IOException {
	        Properties properties = new Properties();
	        properties.load(getClass().getResourceAsStream(getPropertyFile()));
	        return properties;
	    }
	 
	 public static SessionFactory buildSessionFactory(Properties properties) {
	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties)
	            .build();
	        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
	        metadataSources.addAnnotatedClass(Employee.class);
	        factory=  metadataSources.buildMetadata()
	            .buildSessionFactory();
	        return factory;
	    }
	public static  SessionFactory getSessionFactory() {
		return factory;
	}
	
}
