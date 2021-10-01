package com.restapi.hibernate.multitenancy;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

	static String DEFAULT_TENANT = "defaultTenant";
	@Override
	public String resolveCurrentTenantIdentifier() {
		String currentTenant = TenantContext.getCurrentTenant();
		System.out.println("====resolveCurrentTenantIdentifier===");
		return currentTenant != null ? currentTenant : DEFAULT_TENANT;
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		// TODO Auto-generated method stub
		return true;
	}

}
