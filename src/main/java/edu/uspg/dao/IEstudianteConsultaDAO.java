package edu.uspg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.uspg.model.EstudianteConsulta;

public interface IEstudianteConsultaDAO extends JpaRepository<EstudianteConsulta , Integer>{
	
	@Query(value=" SELECT * from public.\"estudiantesClase\"(:id)", nativeQuery = true)
	List<Object[]> estudiantesClase(@Param("id") Integer id);

	@Query(value=" SELECT * from public.\"estudiantesFacultad\"(:id)", nativeQuery = true)
	List<Object[]> estudiantesFacultad(@Param("id") Integer id);
}
