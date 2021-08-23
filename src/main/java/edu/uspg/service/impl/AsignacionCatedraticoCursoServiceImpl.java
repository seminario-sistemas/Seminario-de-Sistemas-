package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.IAsignacionCatedraticoCursoDAO;
import edu.uspg.model.AsignacionCatedraticoCurso;
import edu.uspg.service.IAsignacionCatedraticoCursoService;

@Service
public class AsignacionCatedraticoCursoServiceImpl implements IAsignacionCatedraticoCursoService {

	@Autowired
	private IAsignacionCatedraticoCursoDAO dao;	
	
	@Override
	public AsignacionCatedraticoCurso registrar(AsignacionCatedraticoCurso t) {
		return dao.save(t);
	}

	@Override
	public AsignacionCatedraticoCurso modificar(AsignacionCatedraticoCurso t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<AsignacionCatedraticoCurso> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<AsignacionCatedraticoCurso> listar() {
		return dao.findAll();
	}

}
