package com.orangeTalents.carControl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orangeTalents.carControl.DTO.UsuarioDTO;
import com.orangeTalents.carControl.DTO.VeiculoDTO;
import com.orangeTalents.carControl.model.Usuario;
import com.orangeTalents.carControl.model.Veiculo;
import com.orangeTalents.carControl.repository.UsuarioRepository;
import com.orangeTalents.carControl.service.UsuarioService;
import com.orangeTalents.carControl.service.VeiculoService;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class apiController {

	@Autowired UsuarioService usuarioService;
	@Autowired UsuarioRepository usuarioRepository;
	@Autowired VeiculoService veiculoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) //Status 201 Created
	public Usuario adicionar(@Validated @RequestBody Usuario usuario) {
		return usuarioService.adicionar(usuario);
	}
	
	@PostMapping("/{usuarioId}/veiculo")
	@ResponseStatus(HttpStatus.CREATED) //Status 201 Created
	public VeiculoDTO adicionarVeiculo(@Validated @RequestBody Veiculo veiculo, @PathVariable("usuarioId") Long id) {
		return veiculoService.adicionar(veiculo, id);
	}
	
	@GetMapping("/{usuarioId}")
	public ResponseEntity<UsuarioDTO> buscar(@PathVariable("usuarioId") Long id) {
		UsuarioDTO usuario = usuarioService.buscarUsuario(id);
		return ResponseEntity.ok(usuario); //Status 200 OK
	}
}
