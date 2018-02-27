package com.iordneto.userCrud.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.utils.IndexType;

@Entity
@Indexes(@Index(fields = @Field(value = "$**", type = IndexType.TEXT)))
public class User {
	@Id
	private ObjectId id;
	
	@NotNull(message="Nome deve ser preenchido.")
	private String nome;
	
	@NotNull(message="E-mail deve ser preenchido.")
	@Pattern(regexp=".+@.+\\.[a-z]+", message="E-mail inválido")
	private String email;
	
	@NotNull(message="Endereço deve ser preenchido.")
	private String endereco;
	
	@NotNull(message="Telefone deve ser preenchido.")
	private String telefone;
	
	@NotNull(message="Senha deve ser preenchida.")
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")
	private String senha;

	public User() {
		
	}
	
	public User(ObjectId id, String nome, String email, String endereco, String telefone, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
		this.senha = senha;
	}

	public String getId() {
	    return id.toString();
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}