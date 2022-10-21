package com.neurotech.residenciaprojeto.controllers;

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

import com.neurotech.residenciaprojeto.entities.Clinica;
import com.neurotech.residenciaprojeto.repositories.ClinicaRepository;

@RestController
@RequestMapping(value = "/clinica")
public class ClinicaController {

	@Autowired
	private ClinicaRepository repository;

	@GetMapping
	public Page<Clinica> findAll(Pageable pageable) {
		Page<Clinica> result = repository.findAll(pageable);
		return result;
	}
	@GetMapping(value = "/{id}")
	public Clinica findById(@PathVariable Long id) {
		Clinica result = repository.findById(id).get();
		return result;
	}
	@PostMapping
	public Clinica insert(@RequestBody Clinica clinica) {
		Clinica result = repository.save(clinica);
		return result;
	}
	@DeleteMapping(value = "/delete-{id}")
	public void deleteById(@PathVariable Long id) {
		repository.deleteById(id);
	}
	@PutMapping(value = "/update-{id}")
	public ResponseEntity<Clinica>  updateUser(@PathVariable Long id, @RequestBody Clinica clinica) {
		Clinica newClinica = repository.findById(id).get();
		newClinica.setEmail(clinica.getEmail());
		newClinica.setTelefone(clinica.getTelefone());
		repository.save(newClinica);
		return ResponseEntity.ok(newClinica);
	}
}
