package com.orangeTalents.carControl.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.orangeTalents.carControl.DTO.VeiculoDTO;
import com.orangeTalents.carControl.model.ApiResponse;

@FeignClient(name = "veiculo", url="https://parallelum.com.br/fipe/api/v1/carros")
public interface FipeApi {

	@GetMapping(value = "/marcas")
	public List<ApiResponse> getMarcas();
	
	@GetMapping(value = "/marcas/{idMarca}/modelos")
	public ApiResponse getModelos(@PathVariable("idMarca") String idMarca);

	@GetMapping(value = "/marcas/{idMarca}/modelos/{idModelo}/anos")
	public List<ApiResponse> getAnos(@PathVariable("idMarca") String idMarca, @PathVariable("idModelo") String idModelo);

	@GetMapping(value = "/marcas/{idMarca}/modelos/{idModelo}/anos/{idAno}")
	public VeiculoDTO getVeiculo(@PathVariable("idMarca") String idMarca, @PathVariable("idModelo") String idModelo, @PathVariable("idAno") String idAno);
}
