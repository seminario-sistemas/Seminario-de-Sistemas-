package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.Registro;

public interface IRegistroDAO extends JpaRepository<Registro , Integer> {
	 
}
