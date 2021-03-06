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
import edu.uspg.model.Registro;
import edu.uspg.service.IRegistroService;


@RestController
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	private IRegistroService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) public
	 ResponseEntity<List<Registro>> listar(){ 
		return new ResponseEntity<List<Registro>>(service.listar(), HttpStatus.OK); 
	 }
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public EntityModel<Registro> listarPorId(@PathVariable("id") Integer id){ 
		Optional<Registro> registro = service.listarPorId(id);
		
		if(!registro.isPresent()) {
			//throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		EntityModel<Registro> resource = EntityModel.of(registro.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		resource.add(linkTo.withRel("registro-resource")); 
		return resource;
	}
	
	@GetMapping(value = "prueba/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public EntityModel<Registro> listarPorId2(@PathVariable("id") Integer id){ 
		Optional<Registro> registro = service.listarPorId(id);
		
		if(!registro.isPresent()) {
			//throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		EntityModel<Registro> resource = EntityModel.of(registro.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId2(id));
		
		resource.add(linkTo.withRel("registro-resource")); 
		return resource;
	}
	
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> registrar(@RequestBody @Valid Registro reg) { 
		Registro registro = service.registrar(reg);
						
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(registro.getId()).toUri();
		
		
		return ResponseEntity.created(location).build();
	}				
	 
	 @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	 public  ResponseEntity<Object> modificar(@RequestBody Registro registr) { 
		 Optional<Registro> registro = service.listarPorId(registr.getId());
		 if(!registro.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + registr.getId());
		 }else {
			 service.modificar(registr);
		 }
		 return new ResponseEntity<Object>(HttpStatus.OK);
		 
	}
	 
	 @DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<Registro> registr = service.listarPorId(id);
		 if(!registr.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		 
	 }	
	
}
