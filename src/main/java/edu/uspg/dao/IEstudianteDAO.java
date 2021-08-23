package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.Estudiante;

public interface IEstudianteDAO extends JpaRepository<Estudiante , Integer> {

}
