package edu.uspg.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.IEstudianteDAO;
import edu.uspg.model.Estudiante;
import edu.uspg.model.Facultad;
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
	
	@Override
	public List<Estudiante> buscarEstudiantePorCarnet(Integer carnet) {
		List<Estudiante> consulta = new ArrayList<>();
		dao.buscarEstudiantePorCarnet(carnet).forEach(estudiante ->{
			Estudiante est = new Estudiante();
			est.setId(Integer.parseInt(String.valueOf(estudiante[0])));
			est.setNombre(String.valueOf(estudiante[0]));
			est.setCorreo_personal(String.valueOf(estudiante[0]));
			est.setDpi(String.valueOf(estudiante[0]));
			est.setCarnet(Integer.parseInt(String.valueOf(estudiante[0])));
			est.setEdad(Integer.parseInt(String.valueOf(estudiante[0])));
			est.setJornada(String.valueOf(estudiante[0]));
			Facultad facultad = new Facultad();
			facultad.setId(Integer.parseInt(String.valueOf(estudiante[0])));
			est.setFacultad(facultad);
			consulta.add(est);
		});
		return consulta;
	}

}
