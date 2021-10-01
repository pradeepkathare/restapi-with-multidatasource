package com.restapi.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import com.restapi.hibernate.multitenancy.TenantContext;

@WebListener
public class RequestListener implements ServletRequestListener  {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent servletRequestEvent) {
		System.out.println("=====RequestListener========");
		HttpServletRequest servletRequest =  (HttpServletRequest) servletRequestEvent.getServletRequest();
		
		String tenantId = servletRequest.getHeader("tenantID");
		System.out.println("tenantID-"+tenantId);
		TenantContext.setCurrentTenant(tenantId);
	}

}
