package com.orangeTalents.carControl.model;

import java.util.List;


public class ApiResponse {
	
	private String nome;
	private String codigo;
	//atributo necessário devido a API FIPE listar os modelos a partir de uma lista modelos.
	private List<ApiResponse> modelos;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public List<ApiResponse> getModelos() {
		return modelos;
	}
	public void setModelos(List<ApiResponse> modelos) {
		this.modelos = modelos;
	}
}
