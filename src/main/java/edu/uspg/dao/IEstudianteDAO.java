package edu.uspg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.uspg.model.Estudiante;

public interface IEstudianteDAO extends JpaRepository<Estudiante , Integer> {
	
	@Query(value=" select * from estudiante where carnet = :carnet", nativeQuery = true)
	List<Object[]> buscarEstudiantePorCarnet(@Param("carnet") Integer carnet);
}
