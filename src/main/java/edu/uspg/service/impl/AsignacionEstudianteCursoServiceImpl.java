package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.IAsignacionEstudianteCursoDAO;
import edu.uspg.model.AsignacionEstudianteCurso;
import edu.uspg.service.IAsignacionEstudianteCursoService;

@Service
public class AsignacionEstudianteCursoServiceImpl implements IAsignacionEstudianteCursoService {

	@Autowired
	private IAsignacionEstudianteCursoDAO dao;	
	
	@Override
	public AsignacionEstudianteCurso registrar(AsignacionEstudianteCurso t) {
		return dao.save(t);
	}

	@Override
	public AsignacionEstudianteCurso modificar(AsignacionEstudianteCurso t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<AsignacionEstudianteCurso> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<AsignacionEstudianteCurso> listar() {
		return dao.findAll();
	}

}
