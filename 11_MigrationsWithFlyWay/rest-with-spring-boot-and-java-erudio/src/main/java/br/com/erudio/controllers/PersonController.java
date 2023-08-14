package br.com.erudio.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.services.PersonServices;

@RestController	
@RequestMapping("/api/person/v1")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	@GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVO> findAll() 	
	{
		return service.findAll();	
	}

	@GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO findById(@PathVariable Long id) 	
	{
		return service.findById(id);	
	}
	
	@PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO create(@RequestBody PersonVO person) 	
	{
		return service.create(person);	
	}		
	
	@PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO update(@RequestBody PersonVO person) 	
	{
		return service.update(person);	
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) 	
	{
		service.delete(id);	
		return ResponseEntity.noContent().build();
	}	
	
	
}
