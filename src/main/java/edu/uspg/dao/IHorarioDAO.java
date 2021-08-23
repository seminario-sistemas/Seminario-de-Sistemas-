package edu.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uspg.model.Horario;

public interface IHorarioDAO extends JpaRepository<Horario , Integer> {

}
