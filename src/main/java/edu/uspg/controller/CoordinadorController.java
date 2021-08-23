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
import edu.uspg.model.Coordinador;
import edu.uspg.service.ICoordinadorService;


@RestController
@RequestMapping("/coordinador")
public class CoordinadorController {

	@Autowired
	private ICoordinadorService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) public
	 ResponseEntity<List<Coordinador>> listar(){ 
		return new ResponseEntity<List<Coordinador>>(service.listar(), HttpStatus.OK); 
	 }
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public EntityModel<Coordinador> listarPorId(@PathVariable("id") Integer id){ 
		Optional<Coordinador> coordinador = service.listarPorId(id);
		
		if(!coordinador.isPresent()) {
			//throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		EntityModel<Coordinador> resource = EntityModel.of(coordinador.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		resource.add(linkTo.withRel("coordinador-resource"));
		//return service.listarPorId(id);
		return resource;
	}
	
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> registrar(@RequestBody @Valid Coordinador cordi) { 
		Coordinador coordinador = service.registrar(cordi);
						
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(coordinador.getId()).toUri();
		
		
		return ResponseEntity.created(location).build();
	}				
	 
	 @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	 public  ResponseEntity<Object> modificar(@RequestBody Coordinador coordinad) { 
		 Optional<Coordinador> coordinador = service.listarPorId(coordinad.getId());	
		 if(!coordinador.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + coordinad.getId());
		 }else {
			 service.modificar(coordinad);
		 }
		 return new ResponseEntity<Object>(HttpStatus.OK);
		 
		 //return service.modificar(coordinador); 
	}
	 
	 @DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<Coordinador> coordinad = service.listarPorId(id);
		 if(!coordinad.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		 
	 }	
}
