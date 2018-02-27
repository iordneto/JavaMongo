package com.iordneto.userCrud.resources.beans;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {

	private @QueryParam("pagina") int pagina;
	private @QueryParam("tamanho") int tamanho;
	private @QueryParam("pesquisa") String pesquisa;
	private @QueryParam("ordem") String camposOrdem;
	
	public int getPagina() {
		return pagina;
	}
	
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public String getPesquisa() {
		return pesquisa;
	}
	
	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	public String getCamposOrdem() {
		return camposOrdem;
	}
	
	public void setCamposOrdem(String camposOrdem) {
		this.camposOrdem = camposOrdem;
	}
	
	
}