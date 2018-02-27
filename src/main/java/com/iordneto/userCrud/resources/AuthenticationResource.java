package com.iordneto.userCrud.resources;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("user")
@Stateless
@LocalBean
public class AuthenticationResource {

	@POST
	public Response login(
			@FormParam("email") String email,
			@FormParam("senha") int senha) {
		
		return Response.ok().build();
	}
}