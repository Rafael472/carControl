package com.orangeTalents.carControl.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangeTalents.carControl.DTO.UsuarioDTO;
import com.orangeTalents.carControl.DTO.VeiculoDTO;
import com.orangeTalents.carControl.exception.EntidadeNaoEncontradaException;
import com.orangeTalents.carControl.exception.NegocioException;
import com.orangeTalents.carControl.model.Usuario;
import com.orangeTalents.carControl.model.Veiculo;
import com.orangeTalents.carControl.repository.UsuarioRepository;
import com.orangeTalents.carControl.repository.VeiculoRepository;

@Service
public class UsuarioService {

	@Autowired UsuarioRepository usuarioRepository;
	@Autowired VeiculoRepository veiculoRepository;
	@Autowired VeiculoService veiculoService;
	
	public Usuario adicionar(Usuario usuario) {
		Usuario usuarioExiste = usuarioRepository.findByEmailOrCpf(usuario.getEmail(), usuario.getCpf());
		if(usuarioExiste != null && !usuarioExiste.equals(usuario))
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail ou cpf");
		
		return usuarioRepository.save(usuario);
	}

	public UsuarioDTO buscarUsuario(Long id) {
		//checa se usuario existe
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Usuario id " + id + " não encontrado."));
		
		//busca os veiculos do usuario
		List<Veiculo> veiculos = veiculoRepository.findById_usuario(usuario);
		//converte List veiculos para List veiculosDTO 
		List<VeiculoDTO> veiculosDTO = veiculos.stream()
				.map(veiculo -> new VeiculoDTO(veiculo))
				.collect(Collectors.toList());
		
		//calcula diaRodizio e rodizioAtivo
		veiculosDTO = veiculoService.calcularRodizio(veiculosDTO);
		//instancia UsuarioDTO, atribui os veículos e retona usuarioDTO
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		usuarioDTO.setVeiculos(veiculosDTO);
		return usuarioDTO;
	}
}
