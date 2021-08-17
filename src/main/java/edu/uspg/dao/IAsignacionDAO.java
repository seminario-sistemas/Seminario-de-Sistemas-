package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.Asignacion;

public interface IAsignacionDAO extends JpaRepository<Asignacion, Integer> {

}
