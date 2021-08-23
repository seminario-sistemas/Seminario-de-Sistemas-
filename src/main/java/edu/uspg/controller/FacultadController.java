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
import edu.uspg.model.Facultad;
import edu.uspg.service.IFacultadService;


@RestController
@RequestMapping("/facultad")
public class FacultadController {

	@Autowired
	private IFacultadService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) public
	 ResponseEntity<List<Facultad>> listar(){ 
		return new ResponseEntity<List<Facultad>>(service.listar(), HttpStatus.OK); 
	 }
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public EntityModel<Facultad> listarPorId(@PathVariable("id") Integer id){ 
		Optional<Facultad> facultad = service.listarPorId(id);
		
		if(!facultad.isPresent()) {
			//throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		EntityModel<Facultad> resource = EntityModel.of(facultad.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		resource.add(linkTo.withRel("facultad-resource"));
		//return service.listarPorId(id);
		return resource;
	}
	
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> registrar(@RequestBody @Valid Facultad facu) { 
		Facultad facultad = service.registrar(facu);
						
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(facultad.getId()).toUri();
		
		
		return ResponseEntity.created(location).build();		
		//return service.registrar(facu); 
	}				
	 
	 @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	 public  ResponseEntity<Object> modificar(@RequestBody Facultad facul) { 
		 Optional<Facultad> facultad = service.listarPorId(facul.getId());
		 if(!facultad.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + facul.getId());
		 }else {
			 service.modificar(facul);
		 }
		 return new ResponseEntity<Object>(HttpStatus.OK);
		 
		 //return service.modificar(facultad); 
	}
	 
	 @DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<Facultad> facul = service.listarPorId(id);
		 if(!facul.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		 
	 }	
}
