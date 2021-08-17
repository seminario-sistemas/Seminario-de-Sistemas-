package edu.uspg.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.uspg.dto.AsignacionLibroDTO;
import edu.uspg.exception.ModeloNotFoundException;
import edu.uspg.model.Asignacion;
import edu.uspg.service.IAsignacionService;

@RestController
@RequestMapping("/asignacion")
public class AsignacionController {

	@Autowired
	private IAsignacionService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) public
	 ResponseEntity<List<Asignacion>> listar(){ 
		return new ResponseEntity<List<Asignacion>>(service.listar(), HttpStatus.OK); 
	 }
	
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public EntityModel<Asignacion> listarPorId(@PathVariable("id") Integer id){ 
		Optional<Asignacion> asignacion = service.listarPorId(id);
		
		if(!asignacion.isPresent()) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		EntityModel<Asignacion> resource = EntityModel.of(asignacion.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		resource.add(linkTo.withRel("asignacion-resource"));
		//return service.listarPorId(id);
		return resource;
	}
	
	@Transactional
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> registrar(@RequestBody AsignacionLibroDTO asigDTO) { 
		
		Asignacion asignacion = service.registrarTransaccional(asigDTO);
						
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(asignacion.getId()).toUri();
				
		return ResponseEntity.created(location).build();		
		//return service.registrar(alu); 
	}	
	
	
}
