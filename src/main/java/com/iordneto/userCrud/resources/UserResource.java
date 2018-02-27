package com.iordneto.userCrud.resources;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.iordneto.userCrud.entities.User;
import com.iordneto.userCrud.resources.beans.MessageFilterBean;
import com.iordneto.userCrud.services.UserService;

@Path("secure/user")
@Stateless
@LocalBean
public class UserResource {

	@EJB
	UserService service;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response listarUsuarios(@BeanParam MessageFilterBean filterBean) {
		
		return Response.ok(
				service.pesquisar(
						filterBean.getPesquisa(),
						filterBean.getCamposOrdem(),
						filterBean.getPagina(), 
						filterBean.getTamanho()))
				.build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarPorId(@PathParam("id") String id) {
		return Response.ok(service.listarPorId(id)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserir(@Valid User user) {
		return Response.status(Response.Status.CREATED).entity(service.inserir(user)).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") String id, User user) {
		return Response.status(Response.Status.CREATED).entity(service.atualizar(id, user)).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response remover(@PathParam("id") String id) {
		return Response.ok(service.remover(id)).build();
	}
}
