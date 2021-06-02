package com.orangeTalents.carControl.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangeTalents.carControl.DTO.VeiculoDTO;
import com.orangeTalents.carControl.exception.BadRequestException;
import com.orangeTalents.carControl.exception.EntidadeNaoEncontradaException;
import com.orangeTalents.carControl.model.ApiResponse;
import com.orangeTalents.carControl.model.Usuario;
import com.orangeTalents.carControl.model.Veiculo;
import com.orangeTalents.carControl.repository.UsuarioRepository;
import com.orangeTalents.carControl.repository.VeiculoRepository;

@Service

public class VeiculoService {

	@Autowired UsuarioRepository usuarioRepository;
	@Autowired VeiculoRepository veiculoRepository;
	@Autowired FipeApi api;
	
	public VeiculoDTO adicionar(Veiculo veiculo, Long id) {
		//checa se id é de usuário válido
		//lança exception com status 404 caso usuário não exista
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Usuario id " + id + " não encontrado."));
		
		//checa se marca existe
		//lança exception con status 400 caso marca não encontrada
		List<ApiResponse> marcas = api.getMarcas(); //busca marcas na api fipe
		ApiResponse marca = new ApiResponse();
		marca = listContains(veiculo.getMarca(), marcas);
		if(marca == null)
			throw new BadRequestException("Marca '" + veiculo.getMarca() + "' não encontrada. Insira uma marca válida.");
		
		//checa se modelo existe
		//lança exception con status 400 caso modelo não encontrado
		ApiResponse modelo = new ApiResponse();
		List<ApiResponse> modelos = api.getModelos(marca.getCodigo()).getModelos(); //busca modelos na api fipe
		modelo = listContains(veiculo.getModelo(), modelos);
		if(modelo == null)
			throw new BadRequestException("Modelo '" + veiculo.getModelo() + "' não encontrado. Insira um modelo válido.");
		
		//checa se ano existe
		//lança exception con status 400 caso ano não encontrado
		ApiResponse ano = new ApiResponse();
		List<ApiResponse> anos = api.getAnos(marca.getCodigo(), modelo.getCodigo()); //busca anos na api fipe
		ano = listContains(veiculo.getAno(), anos);
		if(ano == null)
			throw new BadRequestException("Ano '" + veiculo.getAno() + "' não encontrado. Insira um ano válido.");
		
		//prepara objeto veiculo para ser salvo no banco de dados
		VeiculoDTO veiculoDTO = api.getVeiculo(marca.getCodigo(), modelo.getCodigo(), ano.getCodigo());
		veiculo = new Veiculo(veiculoDTO);
		veiculo.setIdProprietario(usuario);
		veiculo = veiculoRepository.save(veiculo);
		
		//prepara dto para retorno customizado ao usuario
		veiculoDTO = new VeiculoDTO(veiculo);
		veiculoDTO = calcularRodizio(veiculoDTO);
		return veiculoDTO;
	}
	
	//procura item na lista, caso encontrar retorna o item, senão, retona null
	private ApiResponse listContains(String item, List<ApiResponse> lista){
		for (ApiResponse temp : lista) {
			if(temp.getNome().contains(item)) {
				return temp;
			}
		}
		return null;
	}
	
	//calcula rodizio para Objeto VeiculoDTO
	VeiculoDTO calcularRodizio(VeiculoDTO veiculo) {
		Calendar c = Calendar.getInstance(); //instancia de calendario
		String hoje = getDiaDaSemana(c.get(Calendar.DAY_OF_WEEK)); //dia de hoje
		
		String ano = veiculo.AnoModelo; //String ano = Ano do veiculo
		int digito = Integer.parseInt(ano.substring(ano.length() -1)); //int digito = ultimo dígito do ano do veiculo
		veiculo.diaRodizio = getDiaDaSemana(digito); //seta dia do ridizio do veículo
		
		//se dia do rodizio = hoje , rodizioAtivo = true
		if(veiculo.diaRodizio.equals(hoje))
			veiculo.rodizioAtivo = true;
		
		return veiculo;
	}
	
	//calcula rodizio para Lista VeiculoDTO	
	List<VeiculoDTO> calcularRodizio(List<VeiculoDTO> veiculos) {
		//percorre a lista para setar dia de rodizio
		for (int i = 0; i < veiculos.size(); i++) {
			veiculos.set(i, calcularRodizio(veiculos.get(i)));
		}
		return veiculos;
	}
	
	//busca dia da semana correspondente ao digito do ano do veiculo
	private String getDiaDaSemana(int value) {
		String day = "";
	    switch(value){
	    case 0:
	    case 1:
	        day="Segunda-feira";
	        break;
	    case 2:
	    case 3:
	        day="Terça-feira";
	        break;
	    case 4:
	    case 5:
	        day="Quarta-feira";
	        break;
	    case 6:
	    case 7:
	        day="Quinta-feira";
	        break;
	    case 8:
	    case 9:
	        day="Sexta-feira";
	        break;
	    }
	    return day;
	}
	
}
