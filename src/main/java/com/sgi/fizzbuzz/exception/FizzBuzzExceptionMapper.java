package com.sgi.fizzbuzz.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * FizzBuz exception 
 * 
 * @author sgillet
 *
 */
@Provider
public class FizzBuzzExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		
		Response.StatusType type = getStatusType(ex);

		FizzBuzzError error = new FizzBuzzError(
                type.getStatusCode(),
                type.getReasonPhrase(),
                ex.getLocalizedMessage());

        return Response.status(error.getStatusCode())
                .entity(error)
                .type(MediaType.APPLICATION_JSON)
                .build();
	}
	
	
	/**
	 * Get the error status of the web service for the given exception 
	 * 
	 * @param ex Exception
	 * @return error status
	 */
	private Response.StatusType getStatusType(Throwable ex) {
        if (ex instanceof WebApplicationException) {
        	return ( (WebApplicationException) ex).getResponse().getStatusInfo();
        } else if (ex instanceof IllegalArgumentException)  {
        	return Response.Status.BAD_REQUEST;
        } else {
        	return Response.Status.INTERNAL_SERVER_ERROR;
        }
    }

}
