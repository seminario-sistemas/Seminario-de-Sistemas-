package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.IRegistroDAO;
import edu.uspg.model.Registro;
import edu.uspg.service.IRegistroService;

@Service
public class RegistroServiceImpl implements IRegistroService {

	@Autowired
	private IRegistroDAO dao;	
	
	@Override
	public Registro registrar(Registro t) {
		return dao.save(t);
	}

	@Override
	public Registro modificar(Registro t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Registro> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Registro> listar() {
		return dao.findAll();
	}

}
