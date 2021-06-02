package com.orangeTalents.carControl.DTO;

import com.orangeTalents.carControl.model.Veiculo;

public class VeiculoDTO {

	public Long idVeiculo;
	public String Valor;
	public String Marca;
	public String Modelo;
	public String AnoModelo;
	public String Combustivel;
	public Long idProprietario;
	public String diaRodizio;
	public boolean rodizioAtivo;
	
	public VeiculoDTO() {}
	
	public VeiculoDTO(Veiculo veiculo) {
		this.idVeiculo = veiculo.getId();
		this.Valor = veiculo.getValor();
		this.Marca = veiculo.getMarca();
		this.Modelo = veiculo.getModelo();
		this.AnoModelo = veiculo.getAno();
		this.Combustivel = veiculo.getCombustivel();
		this.idProprietario = veiculo.getIdProprietario().getId();
	}
	
	@Override
	public String toString() {
		return "VeiculoDTO [idVeiculo=" + idVeiculo + ", Valor=" + Valor + ", Marca=" + Marca + ", Modelo=" + Modelo
				+ ", AnoModelo=" + AnoModelo + ", Combustivel=" + Combustivel + ", idProprietario=" + idProprietario
				+ "]";
	}
	
}
