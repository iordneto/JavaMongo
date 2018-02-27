package com.iordneto.userCrud.services;

import javax.ejb.Stateless;

import com.iordneto.userCrud.entities.User;

@Stateless
public class AuthenticationService {
	
	UserService userService = new UserService();
	
	public boolean authenticate(String email, String senha) {

		if (email == null || senha == null)
			return false;

		User user = userService.listarPorEmail(email);
		if(user != null) {
			return compararSenhas(user.getSenha(), senha);
		}

		return false;
	}
	
	public boolean compararSenhas(String senhaEncriptada, String senhaTexto) {
		if(senhaEncriptada.equals(senhaTexto))
			return true;
		
		return false;
	}
	
	
	
}