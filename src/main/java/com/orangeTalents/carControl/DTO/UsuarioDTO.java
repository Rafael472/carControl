package com.orangeTalents.carControl.DTO;

import java.util.Date;
import java.util.List;

import com.orangeTalents.carControl.model.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private Date dataNascimento;
	private List<VeiculoDTO> veiculos;
	
	public UsuarioDTO() {}
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.cpf = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public List<VeiculoDTO> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<VeiculoDTO> veiculos) {
		this.veiculos = veiculos;
	}
	
	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento + ", veiculos=" + veiculos + "]";
	}
}
