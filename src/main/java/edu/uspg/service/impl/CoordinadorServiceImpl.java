package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.ICoordinadorDAO;
import edu.uspg.model.Coordinador;
import edu.uspg.service.ICoordinadorService;

@Service
public class CoordinadorServiceImpl implements ICoordinadorService {

	@Autowired
	private ICoordinadorDAO dao;	
	
	@Override
	public Coordinador registrar(Coordinador t) {
		return dao.save(t);
	}

	@Override
	public Coordinador modificar(Coordinador t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Coordinador> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Coordinador> listar() {
		return dao.findAll();
	}

}
