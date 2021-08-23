package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.IAsignacionHorarioCursoDAO;
import edu.uspg.model.AsignacionHorarioCurso;
import edu.uspg.service.IAsignacionHorarioCursoService;

@Service
public class AsignacionHorarioCursoServiceImpl implements IAsignacionHorarioCursoService {

	@Autowired
	private IAsignacionHorarioCursoDAO dao;	
	
	@Override
	public AsignacionHorarioCurso registrar(AsignacionHorarioCurso t) {
		return dao.save(t);
	}

	@Override
	public AsignacionHorarioCurso modificar(AsignacionHorarioCurso t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<AsignacionHorarioCurso> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<AsignacionHorarioCurso> listar() {
		return dao.findAll();
	}

}
