package com.restapi.listeners;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.restapi.hibernate.SessionFactoryService;
import com.restapi.hibernate.multitenancy.ConfigurableMultitenantConnectionProvider;

@WebListener
public class ApplicationListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("====Context intitalization =====");
		//this will load properties files
		ConfigurableMultitenantConnectionProvider configurableMultitenantConnectionProvider= 
				new ConfigurableMultitenantConnectionProvider();
		//SessionFactoryService.buildSessionFactory();
		//2nd way
		SessionFactoryService service = new SessionFactoryService();
		 try {
			Properties properties = service.getHibernateProperties();
			SessionFactoryService.buildSessionFactory(properties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
