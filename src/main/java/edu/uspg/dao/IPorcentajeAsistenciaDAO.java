package edu.uspg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.uspg.model.PorcentajeAsistencia;

public interface IPorcentajeAsistenciaDAO extends JpaRepository<PorcentajeAsistencia , Integer> {
	
	@Query(value=" SELECT * from public.\"porcentajeAsistenciaEstudianteCurso\"(:id,:idCurso)", nativeQuery = true)
	List<Object[]> porcentajeAsistenciasEstudianteCurso(@Param("id") Integer id, @Param("idCurso") Integer idCurso);
	
}
