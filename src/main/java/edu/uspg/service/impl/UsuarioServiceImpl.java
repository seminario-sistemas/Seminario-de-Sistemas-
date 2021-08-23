package edu.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.IUsuarioDAO;
import edu.uspg.model.Usuario;
import edu.uspg.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDAO dao;

	@Override
	public Usuario registrar(Usuario t) {
		return dao.save(t);
	}

	@Override
	public Usuario modificar(Usuario t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Usuario> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Usuario> listar() {
		return dao.findAll();
	}

}