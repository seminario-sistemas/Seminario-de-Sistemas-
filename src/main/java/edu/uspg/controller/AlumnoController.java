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

import edu.uspg.exception.ModeloNotFoundException;
import edu.uspg.model.Alumno;
import edu.uspg.service.IAlumnoService;


@RestController
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	private IAlumnoService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) public
	 ResponseEntity<List<Alumno>> listar(){ 
		return new ResponseEntity<List<Alumno>>(service.listar(), HttpStatus.OK); 
	 }
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public EntityModel<Alumno> listarPorId(@PathVariable("id") Integer id){ 
		Optional<Alumno> alumno = service.listarPorId(id);
		
		if(!alumno.isPresent()) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		EntityModel<Alumno> resource = EntityModel.of(alumno.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		resource.add(linkTo.withRel("alumno-resource"));
		//return service.listarPorId(id);
		return resource;
	}
	
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> registrar(@RequestBody @Valid Alumno alu) { 
		Alumno alumno = service.registrar(alu);
						
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(alumno.getId()).toUri();
		
		
		return ResponseEntity.created(location).build();		
		//return service.registrar(alu); 
	}				
	 
	 @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	 public  ResponseEntity<Object> modificar(@RequestBody Alumno alum) { 
		 Optional<Alumno> alumno = service.listarPorId(alum.getId());
		 if(!alumno.isPresent()) {
			 throw new ModeloNotFoundException("ID NO ENCONTRADO: " + alum.getId());
		 }else {
			 service.modificar(alum);
		 }
		 return new ResponseEntity<Object>(HttpStatus.OK);
		 
		 //return service.modificar(alumno); 
	}
	 
	 @DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<Alumno> alum = service.listarPorId(id);
		 if(!alum.isPresent()) {
			 throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		 
	 }
	
	
	
	
	
}
