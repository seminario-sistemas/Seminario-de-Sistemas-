package edu.uspg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uspg.model.CursoEstudiante;
import edu.uspg.model.EstudianteConsulta;
import edu.uspg.model.PorcentajeAsistencia;
import edu.uspg.service.ICursoEstudianteService;

@RestController
@RequestMapping("/consultas")
public class ConsultasController {
	
	@Autowired
	ICursoEstudianteService service;
	
	@GetMapping(value = "cursosCatedratico/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<CursoEstudiante>> clasesCatedratico(@PathVariable("id") Integer id){ 
		List<CursoEstudiante> consulta = new ArrayList<>();
		consulta = service.clasesCatedratico(id);
		
		ResponseEntity<List<CursoEstudiante>> resource = new ResponseEntity<List<CursoEstudiante>>(consulta,HttpStatus.OK);
		return resource;
	}
	
	@GetMapping(value = "cursosEstudiante/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<CursoEstudiante>> clasesEstudiante(@PathVariable("id") Integer id){ 
		List<CursoEstudiante> consulta = new ArrayList<>();
		consulta = service.clasesEstudiante(id);
		
		ResponseEntity<List<CursoEstudiante>> resource = new ResponseEntity<List<CursoEstudiante>>(consulta,HttpStatus.OK);
		return resource;
	}
	
	@GetMapping(value = "cursosEstudianteManana/{id}/{diaSemana}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<CursoEstudiante>> clasesEstudianteManana(@PathVariable("id") Integer id, @PathVariable("diaSemana") Integer diaSemana){ 
		List<CursoEstudiante> consulta = new ArrayList<>();
		consulta = service.clasesEstudianteManana(id, diaSemana);
		
		ResponseEntity<List<CursoEstudiante>> resource = new ResponseEntity<List<CursoEstudiante>>(consulta,HttpStatus.OK);
		return resource;
	}
	
	@GetMapping(value = "cursosCatedraticoManana/{id}/{diaSemana}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<CursoEstudiante>> clasesCatedraticoManana(@PathVariable("id") Integer id, @PathVariable("diaSemana") Integer diaSemana){ 
		List<CursoEstudiante> consulta = new ArrayList<>();
		consulta = service.clasesCatedraticoManana(id, diaSemana);
		
		ResponseEntity<List<CursoEstudiante>> resource = new ResponseEntity<List<CursoEstudiante>>(consulta,HttpStatus.OK);
		return resource;
	}
	
	@GetMapping(value = "es_claseAnteriorActualSiguiente/{id}/{hora}/{numeroDia}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<CursoEstudiante>> es_claseAnteriorActualSiguiente(@PathVariable("id") Integer id, @PathVariable("hora") Integer hora, @PathVariable("numeroDia") Integer numeroDia){ 
		List<CursoEstudiante> consulta = new ArrayList<>();
		consulta = service.es_claseAnteriorActualSiguiente(id, hora, numeroDia);
		
		ResponseEntity<List<CursoEstudiante>> resource = new ResponseEntity<List<CursoEstudiante>>(consulta,HttpStatus.OK);
		return resource;
	}
	
	@GetMapping(value = "ca_claseAnteriorActualSiguiente/{id}/{hora}/{numeroDia}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<CursoEstudiante>> ca_claseAnteriorActualSiguiente(@PathVariable("id") Integer id, @PathVariable("hora") Integer hora, @PathVariable("numeroDia") Integer numeroDia){ 
		List<CursoEstudiante> consulta = new ArrayList<>();
		consulta = service.ca_claseAnteriorActualSiguiente(id, hora, numeroDia);
		
		ResponseEntity<List<CursoEstudiante>> resource = new ResponseEntity<List<CursoEstudiante>>(consulta,HttpStatus.OK);
		return resource;
	}


	
	@GetMapping(value = "estudiantesClase/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<EstudianteConsulta>> estudiantesClase(@PathVariable("id") Integer id){ 
		List<EstudianteConsulta> consulta = new ArrayList<>();
		consulta = service.estudiantesClase(id);
		
		ResponseEntity<List<EstudianteConsulta>> resource = new ResponseEntity<List<EstudianteConsulta>>(consulta,HttpStatus.OK);
		return resource;
	}
	
	@GetMapping(value = "estudiantesFacultad/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<EstudianteConsulta>> estudiantesFacultad(@PathVariable("id") Integer id){ 
		List<EstudianteConsulta> consulta = new ArrayList<>();
		consulta = service.estudiantesFacultad(id);
		
		ResponseEntity<List<EstudianteConsulta>> resource = new ResponseEntity<List<EstudianteConsulta>>(consulta,HttpStatus.OK);
		return resource;
	}
	
	@GetMapping(value = "porcentajeAsistenciasEstudianteCurso/{id}/{idCurso}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<PorcentajeAsistencia>> ca_claseAnteriorActualSiguiente(@PathVariable("id") Integer id, @PathVariable("idCurso") Integer idCurso){ 
		List<PorcentajeAsistencia> consulta = new ArrayList<>();
		consulta = service.porcentajeAsistenciasEstudianteCurso(id, idCurso);
		
		ResponseEntity<List<PorcentajeAsistencia>> resource = new ResponseEntity<List<PorcentajeAsistencia>>(consulta,HttpStatus.OK);
		return resource;
	}
}
