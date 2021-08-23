package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.Coordinador;

public interface ICoordinadorDAO extends JpaRepository<Coordinador , Integer> {

}
