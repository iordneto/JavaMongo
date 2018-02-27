package com.iordneto.userCrud.DAO;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

import com.iordneto.userCrud.entities.User;

public interface UserDAO extends DAO<User, ObjectId> {
	public List<User> listarTodos();

	public User listarPorId(String id);

	public User inserir(User user);
	
	public User atualizar(String id, User user);
	
	public boolean remover(String id );
	
}
