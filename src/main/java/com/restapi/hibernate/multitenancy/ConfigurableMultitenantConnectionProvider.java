package com.restapi.hibernate.multitenancy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.AbstractMultiTenantConnectionProvider;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class ConfigurableMultitenantConnectionProvider extends AbstractMultiTenantConnectionProvider {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String FRONT_END_TENANT = null;
	private final Map<String, ConnectionProvider> connectionProviderMap = new HashMap<>(  );
	
	//this to make proper
	 public ConfigurableMultitenantConnectionProvider() {

		 try {
			 //read from propertyfile for all tenant
			 //initConnectionProviderForTenant("defaultTenant");
			 initConnectionProviderForTenant("tenantId1");
			 initConnectionProviderForTenant("tenantId2");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	    }
	
	@Override
	protected ConnectionProvider getAnyConnectionProvider() {
		// TODO Auto-generated method stub //should return default tenant-id
		return connectionProviderMap.values().iterator().next();
	}

	@Override
	protected ConnectionProvider selectConnectionProvider(String tenantIdentifier) {
		// TODO Auto-generated method stub
		System.out.println("selectConnectionProvider==========");
		ConnectionProvider connectionProvider = this.connectionProviderMap.get(tenantIdentifier);
        if (connectionProvider == null) {
            //connectionProvider = new ConnectionProviderImpl(CurrentTenantIdentifierResolverImpl.DEFAULT_TENANT_ID);
        }
		 return connectionProviderMap.get( tenantIdentifier );
	}

	
	private void initConnectionProviderForTenant(String tenantId)
		     throws IOException {
		        Properties properties = new Properties();
		        //load all property files
		        properties.load(getClass().getResourceAsStream(
		          String.format("/hibernate-database-%s.properties", tenantId)));
		        DriverManagerConnectionProviderImpl connectionProvider 
		          = new DriverManagerConnectionProviderImpl();
		        connectionProvider.configure(properties);
		        this.connectionProviderMap.put(tenantId, connectionProvider);
		    }
}
