package com.iordneto.userCrud.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.FindOptions;
import org.mongodb.morphia.query.Query;

import com.iordneto.userCrud.DAO.UserDAO;
import com.iordneto.userCrud.entities.User;

@Stateless
@LocalBean
public class UserService extends BasicDAO<User, ObjectId> implements UserDAO {

	private static MorphiaService morphiaService = new MorphiaService();

	public UserService() {
		super(User.class, morphiaService.getDatastore());
		ensureIndexes();
	}

	@Override
	public List<User> listarTodos() {
		
		return find().asList();
	}

	@Override
	public User listarPorId(String id) {
		ObjectId oId = new ObjectId(id);
		return get(oId);
	}

	@Override
	public User inserir(User user) {
		ObjectId oId = (ObjectId) save(user).getId();
		return get(oId);
	}

	@Override
	public User atualizar(String id, User user) {
		user.setId(new ObjectId(id));
		ObjectId oId = (ObjectId) save(user).getId();
		
		return get(oId);
	}

	@Override
	public boolean remover(String id) {

		return deleteById(new ObjectId(id)).getN() > 0;
	}

	public User listarPorEmail(String email) {
		Query<User> q = createQuery().field("email").equal(email);
		return findOne(q);
	}

	public List<User> pesquisar(String pesquisa, String camposOrdem, int pagina, int tamanho) {
		Query<User> q = createQuery();
        
		if(pesquisa != null) q.search(pesquisa);
        
        if(camposOrdem != null) q.order(camposOrdem);
        
        if(pagina > 0 && tamanho > 0) 
        	return find(q).asList(new FindOptions().skip((pagina-1) * tamanho).limit(tamanho));
        
        return listarTodos();
	}
}
