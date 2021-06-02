package com.orangeTalents.carControl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orangeTalents.carControl.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByEmail(String email);
	Usuario findByCpf(String cpf);
	Usuario findByEmailOrCpf(String email, String cpf);

}
