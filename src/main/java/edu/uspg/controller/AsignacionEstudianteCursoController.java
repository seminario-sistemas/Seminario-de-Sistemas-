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
import edu.uspg.model.AsignacionEstudianteCurso;
import edu.uspg.service.IAsignacionEstudianteCursoService;


@RestController
@RequestMapping("/asignacion_estudiante_curso")
public class AsignacionEstudianteCursoController {

	@Autowired
	private IAsignacionEstudianteCursoService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) public
	 ResponseEntity<List<AsignacionEstudianteCurso>> listar(){ 
		return new ResponseEntity<List<AsignacionEstudianteCurso>>(service.listar(), HttpStatus.OK); 
	 }
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public EntityModel<AsignacionEstudianteCurso> listarPorId(@PathVariable("id") Integer id){ 
		Optional<AsignacionEstudianteCurso> asignacion_estudiante_curso = service.listarPorId(id);
		
		if(!asignacion_estudiante_curso.isPresent()) {
			//throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		EntityModel<AsignacionEstudianteCurso> resource = EntityModel.of(asignacion_estudiante_curso.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		resource.add(linkTo.withRel("asignacion_estudiante_curso-resource"));
		//return service.listarPorId(id);
		return resource;
	}

	
	@GetMapping(value = "listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public EntityModel<AsignacionEstudianteCurso> listarPorId_(@PathVariable("id") Integer id){ 
		Optional<AsignacionEstudianteCurso> asignacion_estudiante_curso = service.listarPorId(id);
		
		if(!asignacion_estudiante_curso.isPresent()) {
			//throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		EntityModel<AsignacionEstudianteCurso> resource = EntityModel.of(asignacion_estudiante_curso.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId_(id));
		
		resource.add(linkTo.withRel("asignacion_estudiante_curso-resource"));
		//return service.listarPorId(id);
		return resource;
	}
	
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> registrar(@RequestBody @Valid AsignacionEstudianteCurso asignacion_estu_curso) { 
		AsignacionEstudianteCurso asignacion_estudiante_curso = service.registrar(asignacion_estu_curso);
						
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(asignacion_estudiante_curso.getId()).toUri();
		
		
		return ResponseEntity.created(location).build();		
		//return service.registrar(asignacion_estu_curso); 
	}	
	
	 @DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<AsignacionEstudianteCurso> asign_estu_curso = service.listarPorId(id);
		 if(!asign_estu_curso.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		 
	 }
	
}
