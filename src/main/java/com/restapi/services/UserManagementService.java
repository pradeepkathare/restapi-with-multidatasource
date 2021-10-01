package com.restapi.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.hibernate.Session;

import com.restapi.entites.Employee;
import com.restapi.hibernate.SessionFactoryService;
import com.restapi.hibernate.multitenancy.TenantContext;

@Path("/userManagement")
public class UserManagementService {

	@GET
	@Path("users")
	@Produces("application/html")
	public Response getUsers() {
		String result = "<h1>RESTful Demo Application</h1>In real world application, a collection of users will be returned !!";
        return Response.status(200).entity(result).build();
	}
	
	@GET
    public String getMsg()
    {
         return "Hello World !! - Jersey 2";
    }
	
	@GET
	@Path("user")
    public String getUser()
    {
		Session session = SessionFactoryService.getSessionFactory().withOptions().tenantIdentifier(TenantContext.getCurrentTenant()).openSession();
		
		session.get(Employee.class, 1);
         return "";
    }
	
	
}

