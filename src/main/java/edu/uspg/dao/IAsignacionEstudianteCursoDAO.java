package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.AsignacionEstudianteCurso;

public interface IAsignacionEstudianteCursoDAO extends JpaRepository<AsignacionEstudianteCurso , Integer> {

}
