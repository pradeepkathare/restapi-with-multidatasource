package com.restapi.exceptionmappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.restapi.customexceptions.CustomException;

/*
 * In restapis,whenever we throw exception we should implement exceptionMapper class and override toresponse method
 */
@Provider
public class CustomExceptionMapper implements ExceptionMapper<CustomException>{

	
	

	@Override
	public Response toResponse(CustomException arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
