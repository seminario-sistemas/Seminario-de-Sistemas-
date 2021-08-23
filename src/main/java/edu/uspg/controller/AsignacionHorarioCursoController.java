package edu.uspg.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//import edu.uspg.exception.ModeloNotFoundException;
import edu.uspg.model.AsignacionHorarioCurso;
import edu.uspg.service.IAsignacionHorarioCursoService;


@RestController
@RequestMapping("/asignacion_horario_curso")
public class AsignacionHorarioCursoController {

	@Autowired
	private IAsignacionHorarioCursoService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) public
	 ResponseEntity<List<AsignacionHorarioCurso>> listar(){ 
		return new ResponseEntity<List<AsignacionHorarioCurso>>(service.listar(), HttpStatus.OK); 
	 }
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public EntityModel<AsignacionHorarioCurso> listarPorId(@PathVariable("id") Integer id){ 
		Optional<AsignacionHorarioCurso> asignacion_horario_curso = service.listarPorId(id);
		
		if(!asignacion_horario_curso.isPresent()) {
			//throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		EntityModel<AsignacionHorarioCurso> resource = EntityModel.of(asignacion_horario_curso.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		resource.add(linkTo.withRel("asignacion_horario_curso-resource"));
		//return service.listarPorId(id);
		return resource;
	}
	
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> registrar(@RequestBody @Valid AsignacionHorarioCurso asignacion_horar_curso) { 
		AsignacionHorarioCurso asignacion_horario_curso = service.registrar(asignacion_horar_curso);
						
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(asignacion_horario_curso.getId()).toUri();
		
		
		return ResponseEntity.created(location).build();		
		//return service.registrar(asignacion_horar_curso); 
	}	
	
	 @DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<AsignacionHorarioCurso> asign_hora_curso = service.listarPorId(id);
		 if(!asign_hora_curso.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		 
	 }
	
}
