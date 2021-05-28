package com.orangeTalents.carControl.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orangeTalents.carControl.model.Usuario;

@RestController
@CrossOrigin
public class apiController {

	@RequestMapping({"","/"})
	public Usuario pagina() {
		Usuario user = new Usuario();
		return user;
	}
}
