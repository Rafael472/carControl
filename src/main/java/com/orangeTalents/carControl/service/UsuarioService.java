package com.orangeTalents.carControl.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangeTalents.carControl.DTO.UsuarioDTO;
import com.orangeTalents.carControl.DTO.VeiculoDTO;
import com.orangeTalents.carControl.exception.UsuarioNaoEncontradoException;
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
		return usuarioRepository.save(usuario);
	}

	public UsuarioDTO buscarUsuario(Long id) {
		//checa se usuario existe
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(usuario.isEmpty())
			throw new UsuarioNaoEncontradoException("Usuario id " + id + " não encontrado.");
		
		//busca os veiculos do usuario
		List<Veiculo> veiculos = veiculoRepository.findById_usuario(usuario.get());
		//converte List veiculos para List veiculosDTO 
		List<VeiculoDTO> veiculosDTO = veiculos.stream()
				.map(veiculo -> new VeiculoDTO(veiculo))
				.collect(Collectors.toList());
		
		//adiciona diaRodizio e rodizioAtivo
		veiculosDTO = veiculoService.calcularRodizio(veiculosDTO);
		//retorna usuarioDTO com veículos
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.get());
		usuarioDTO.setVeiculos(veiculosDTO);
		return usuarioDTO;
	}
}
