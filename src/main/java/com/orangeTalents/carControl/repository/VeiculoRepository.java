package com.orangeTalents.carControl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orangeTalents.carControl.model.Usuario;
import com.orangeTalents.carControl.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	@Query("SELECT v FROM Veiculo v WHERE v.idProprietario = :idParam")
	List<Veiculo> findById_usuario(@Param("idParam") Usuario id);

}
