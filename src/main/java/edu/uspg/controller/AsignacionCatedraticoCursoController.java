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
import edu.uspg.model.AsignacionCatedraticoCurso;
import edu.uspg.service.IAsignacionCatedraticoCursoService;


@RestController
@RequestMapping("/asignacion_catedratico_curso")
public class AsignacionCatedraticoCursoController {

	@Autowired
	private IAsignacionCatedraticoCursoService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) public
	 ResponseEntity<List<AsignacionCatedraticoCurso>> listar(){ 
		return new ResponseEntity<List<AsignacionCatedraticoCurso>>(service.listar(), HttpStatus.OK); 
	 }
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public EntityModel<AsignacionCatedraticoCurso> listarPorId(@PathVariable("id") Integer id){ 
		Optional<AsignacionCatedraticoCurso> asign_catedratico_curso = service.listarPorId(id);
		
		if(!asign_catedratico_curso.isPresent()) {
			//throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		EntityModel<AsignacionCatedraticoCurso> resource = EntityModel.of(asign_catedratico_curso.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		resource.add(linkTo.withRel("asign_catedratico_curso-resource"));
		//return service.listarPorId(id);
		return resource;
	}
	
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> registrar(@RequestBody @Valid AsignacionCatedraticoCurso asign_catedra_curso) { 
		AsignacionCatedraticoCurso asign_catedratico_curso = service.registrar(asign_catedra_curso);
						
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(asign_catedratico_curso.getId()).toUri();
		
		
		return ResponseEntity.created(location).build();		
		//return service.registrar(asign_catedra_curso); 
	}	
	
	 @DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<AsignacionCatedraticoCurso> asign_cate_curso = service.listarPorId(id);
		 if(!asign_cate_curso.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		 
	 }
	
}
