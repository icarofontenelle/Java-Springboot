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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.neurotech.residenciaprojeto.entities.Appointment;
import com.neurotech.residenciaprojeto.services.AppointmentService;



@RestController
@RequestMapping(value = "/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService service;
	
	@GetMapping
	public ResponseEntity<Page<Appointment>> findAll(Pageable pageable){
		Page<Appointment> list = service.findAll(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Appointment> findById(@PathVariable Long id) {
		Appointment result = service.findById(id);
		return ResponseEntity.ok().body(result);
	}
	@PostMapping
	public ResponseEntity<Appointment> insert(@RequestBody Appointment obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}/*
	@PutMapping(value = "/{id}")
	public ResponseEntity<Appointment> update(@PathVariable Long id, @RequestBody Appointment obj ){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}*/
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
