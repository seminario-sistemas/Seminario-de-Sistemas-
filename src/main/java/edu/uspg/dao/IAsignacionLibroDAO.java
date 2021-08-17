package edu.uspg.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.uspg.model.AsignacionLibro;

public interface IAsignacionLibroDAO extends JpaRepository<AsignacionLibro, Integer> {

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO asignacion_libro(id_asignacion,id_libro) VALUES(:idAsignacion, :idLibro)", nativeQuery = true)
	Integer registrar(@Param("idAsignacion")Integer idAsignacion, @Param("idLibro")Integer idLibro);
}
