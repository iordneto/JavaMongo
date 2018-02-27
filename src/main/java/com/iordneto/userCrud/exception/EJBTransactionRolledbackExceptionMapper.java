package com.iordneto.userCrud.exception;

import javax.ejb.EJBTransactionRolledbackException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.iordneto.userCrud.entities.ErrorMessage;


@Provider
@Produces(MediaType.APPLICATION_JSON)
public class EJBTransactionRolledbackExceptionMapper implements ExceptionMapper<EJBTransactionRolledbackException> {

	@Override
	public Response toResponse(EJBTransactionRolledbackException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "http://github.com/iordneto");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}