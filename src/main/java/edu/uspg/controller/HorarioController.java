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
import edu.uspg.model.Horario;
import edu.uspg.service.IHorarioService;


@RestController
@RequestMapping("/horario")
public class HorarioController {

	@Autowired
	private IHorarioService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) public
	 ResponseEntity<List<Horario>> listar(){ 
		return new ResponseEntity<List<Horario>>(service.listar(), HttpStatus.OK); 
	 }
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public EntityModel<Horario> listarPorId(@PathVariable("id") Integer id){ 
		Optional<Horario> horario = service.listarPorId(id);
		
		if(!horario.isPresent()) {
			//throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		EntityModel<Horario> resource = EntityModel.of(horario.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		resource.add(linkTo.withRel("horario-resource"));
		//return service.listarPorId(id);
		return resource;
	}

	@GetMapping(value = "obtener_horario/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public EntityModel<Horario> listarPorIdHoraio(@PathVariable("id") Integer id){ 
		Optional<Horario> horario = service.listarPorId(id);
		
		if(!horario.isPresent()) {
			//throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		EntityModel<Horario> resource = EntityModel.of(horario.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorIdHoraio(id));
		
		resource.add(linkTo.withRel("horario-resource"));
		//return service.listarPorId(id);
		return resource;
	}
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> registrar(@RequestBody @Valid Horario hor) { 
		Horario horario = service.registrar(hor);
						
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(horario.getId()).toUri();
		
		
		return ResponseEntity.created(location).build();
	}				
	 
	 @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE) 
	 public  ResponseEntity<Object> modificar(@RequestBody Horario horar) { 
		 Optional<Horario> horario = service.listarPorId(horar.getId());	
		 if(!horario.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + horar.getId());
		 }else {
			 service.modificar(horar);
		 }
		 return new ResponseEntity<Object>(HttpStatus.OK);
		 
		 //return service.modificar(horario); 
	}
	 
	 @DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<Horario> horar = service.listarPorId(id);
		 if(!horar.isPresent()) {
			 //throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		 
	 }	
}
