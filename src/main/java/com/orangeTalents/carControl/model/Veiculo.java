package com.orangeTalents.carControl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orangeTalents.carControl.DTO.VeiculoDTO;


@Entity
@Table(name="veiculo")
public class Veiculo {
	
	@Id
	@Column(name = "id_veiculo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Marca não pode estar em branco ou nulo")
	@Column(name="marca", nullable = false)
	private String marca;
	
	@NotBlank(message = "Modelo não pode estar em branco ou nulo")
	@Column(name="modelo", nullable = false)
	private String modelo;
	
	@NotBlank(message = "Ano não pode estar em branco ou nulo")
	@Column(name="ano", nullable = false)
	private String ano;
	
	@Column(name="combustivel", nullable = false)
	public String Combustivel;
	
	@Column(name = "valor", nullable = false)
	private String valor;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario idProprietario;

	Veiculo(){}
	
	Veiculo(String marca, String modelo, String ano, String valor){
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
	}
	
	public Veiculo(VeiculoDTO dto) {
		this.marca = dto.Marca;
		this.modelo = dto.Modelo;
		this.ano = dto.AnoModelo;
		this.valor = dto.Valor;
		this.Combustivel = dto.Combustivel;
	}
	
	//getters e setters abaixo

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Usuario getIdProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(Usuario idProprietario) {
		this.idProprietario = idProprietario;
	}
	
	public String getCombustivel() {
		return Combustivel;
	}

	public void setCombustivel(String combustivel) {
		Combustivel = combustivel;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", Combustivel="
				+ Combustivel + ", valor=" + valor + ", idProprietario=" + idProprietario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
}
