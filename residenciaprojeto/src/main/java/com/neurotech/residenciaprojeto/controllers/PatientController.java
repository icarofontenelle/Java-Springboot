package com.neurotech.residenciaprojeto.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.neurotech.residenciaprojeto.entities.Patient;
import com.neurotech.residenciaprojeto.services.PatientService;


@RestController
@RequestMapping(value = "/patient")
public class PatientController {

	@Autowired
	private PatientService service;
	
	@GetMapping
	public ResponseEntity<Page<Patient>> findAll(Pageable pageable){
		Page<Patient> list = service.findAll(pageable);
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Patient> findById(@PathVariable Long id) {
		Patient result = service.findById(id);
		return ResponseEntity.ok().body(result);
	}
	@PostMapping
	public ResponseEntity<Patient> insert(@RequestBody Patient obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Patient> update(@PathVariable Long id, @RequestBody Patient obj ){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
