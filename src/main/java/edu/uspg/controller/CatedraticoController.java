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
import edu.uspg.model.Catedratico;
import edu.uspg.service.ICatedraticoService;


@RestController
@RequestMapping("/catedratico")
public class CatedraticoController {

	@Autowired
	private ICatedraticoService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) public
	 ResponseEntity<List<Catedratico>> listar(){ 
		return new ResponseEntity<List<Catedratico>>(service.listar(), HttpStatus.OK); 
	 }
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public EntityModel<Catedratico> listarPorId(@PathVariable("id") Integer id){ 
		Optional<Catedratico> catedratico = service.listarPorId(id);
		
		if(!catedratico.isPresent()) {
			//throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		EntityModel<Catedratico> resource = EntityModel.of(catedratico.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		resource.add(linkTo.withRel("catedratico-resource"));
		//return service.listarPorId(id);
		return resource;
	}
	
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> registrar(@RequestBody @Valid Catedratico cate) { 
		Catedratico catedratico = service.registrar(cate);
						
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(catedratico.getId()).toUri();
		
		
		return ResponseEntity.created(location).build();
	}				
	 
	 @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	 public  ResponseEntity<Object> modificar(@RequestBody Catedratico catedratic) { 
		 Optional<Catedratico> catedratico = service.listarPorId(catedratic.getId());	
		 if(!catedratico.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + catedratic.getId());
		 }else {
			 service.modificar(catedratic);
		 }
		 return new ResponseEntity<Object>(HttpStatus.OK);
		 
		 //return service.modificar(catedratico); 
	}
	 
	 @DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<Catedratico> catedratic = service.listarPorId(id);
		 if(!catedratic.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		 
	 }	
}
