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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//import edu.uspg.exception.ModeloNotFoundException;
import edu.uspg.model.Estudiante;
import edu.uspg.service.IEstudianteService;


@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

	@Autowired
	private IEstudianteService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) public
	 ResponseEntity<List<Estudiante>> listar(){ 
		return new ResponseEntity<List<Estudiante>>(service.listar(), HttpStatus.OK); 
	 }
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public EntityModel<Estudiante> listarPorId(@PathVariable("id") Integer id){ 
		Optional<Estudiante> estudiante = service.listarPorId(id);
		
		if(!estudiante.isPresent()) {
			//throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		EntityModel<Estudiante> resource = EntityModel.of(estudiante.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		resource.add(linkTo.withRel("estudiante-resource"));
		//return service.listarPorId(id);
		return resource;
	}
	
	@GetMapping(value = "buscar/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public EntityModel<Estudiante> listarPorIdE(@PathVariable("id") Integer id){ 
		Optional<Estudiante> estudiante = service.listarPorId(id);
		
		if(!estudiante.isPresent()) {
			//throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		EntityModel<Estudiante> resource = EntityModel.of(estudiante.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorIdE(id));
		
		resource.add(linkTo.withRel("estudiante-resource"));
		//return service.listarPorId(id);
		return resource;
	}
	
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> registrar(@RequestBody @Valid Estudiante estu) { 
		Estudiante estudiante = service.registrar(estu);
						
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(estudiante.getId()).toUri();
		
		
		return ResponseEntity.created(location).build();
	}				
	 
	 @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	 public  ResponseEntity<Object> modificar(@RequestBody Estudiante estudian) { 
		 Optional<Estudiante> estudiante = service.listarPorId(estudian.getId());	
		 if(!estudiante.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + estudian.getId());
		 }else {
			 service.modificar(estudian);
		 }
		 return new ResponseEntity<Object>(HttpStatus.OK);
		 
		 //return service.modificar(estudiante); 
	}
	 
	 @DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<Estudiante> estudian = service.listarPorId(id);
		 if(!estudian.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		 
	 }	
}
