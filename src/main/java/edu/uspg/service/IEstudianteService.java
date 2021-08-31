package edu.uspg.service;

import java.util.List;

import edu.uspg.model.Estudiante;

public interface IEstudianteService extends ICRUD<Estudiante> {

	List<Estudiante> buscarEstudiantePorCarnet(Integer carnet);

}
