package edu.uspg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.uspg.model.CursoEstudiante;

public interface ICursoEstudianteDAO extends JpaRepository<CursoEstudiante , Integer> {	

	@Query(value=" SELECT * from public.\"clasesEstudiante\"(:id)", nativeQuery = true)
	List<Object[]> clasesEstudiante(@Param("id") Integer id);

	@Query(value=" SELECT * from public.\"clasesCatedratico\"(:id)", nativeQuery = true)
	List<Object[]> clasesCatedratico(@Param("id") Integer id);

	@Query(value=" SELECT * from public.\"clasesEstudianteManana\"(:id,:diaSemana)", nativeQuery = true)
	List<Object[]> clasesEstudianteManana(@Param("id") Integer id, @Param("diaSemana") Integer diaSemana);

	@Query(value=" SELECT * from public.\"clasesCatedraticoManana\"(:id,:diaSemana)", nativeQuery = true)
	List<Object[]> clasesCatedraticoManana(@Param("id") Integer id, @Param("diaSemana") Integer diaSemana);
	
	@Query(value=" SELECT * from public.\"es_claseAnteriorActualSiguiente\"(:id,:hora,:numeroDia)", nativeQuery = true)
	List<Object[]> es_claseAnteriorActualSiguiente(@Param("id") Integer id, @Param("hora") Integer hora, @Param("numeroDia") Integer numeroDia);
	
	@Query(value=" SELECT * from public.\"ca_claseAnteriorActualSiguiente\"(:id,:hora,:numeroDia)", nativeQuery = true)
	List<Object[]> ca_claseAnteriorActualSiguiente(@Param("id") Integer id, @Param("hora") Integer hora, @Param("numeroDia") Integer numeroDia);
}
