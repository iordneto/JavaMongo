package com.iordneto.userCrud.services;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.ValidationExtension;

import com.mongodb.MongoClient;
 
public class MorphiaService {
 
	private Morphia morphia;
	private Datastore datastore;
	
	public MorphiaService(){
		MongoClient mongoClient = new MongoClient("127.0.0.1:27017");
		this.morphia = new Morphia();
		new ValidationExtension(morphia);
		String databaseName = "user-crud";
		this.datastore = morphia.createDatastore(mongoClient, databaseName);
		this.datastore.ensureIndexes();
	}
 
	
	public Morphia getMorphia() {
		return morphia;
	}
 
	public void setMorphia(Morphia morphia) {
		this.morphia = morphia;
	}
 
	public Datastore getDatastore() {
		return datastore;
	}
 
	public void setDatastore(Datastore datastore) {
		this.datastore = datastore;
	}
	
}