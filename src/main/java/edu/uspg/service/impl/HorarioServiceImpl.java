package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.IHorarioDAO;
import edu.uspg.model.Horario;
import edu.uspg.service.IHorarioService;

@Service
public class HorarioServiceImpl implements IHorarioService {

	@Autowired
	private IHorarioDAO dao;	
	
	@Override
	public Horario registrar(Horario t) {
		return dao.save(t);
	}

	@Override
	public Horario modificar(Horario t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Horario> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Horario> listar() {
		return dao.findAll();
	}

}
