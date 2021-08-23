package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.IEstudianteDAO;
import edu.uspg.model.Estudiante;
import edu.uspg.service.IEstudianteService;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteDAO dao;	
	
	@Override
	public Estudiante registrar(Estudiante t) {
		return dao.save(t);
	}

	@Override
	public Estudiante modificar(Estudiante t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Estudiante> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Estudiante> listar() {
		return dao.findAll();
	}

}
