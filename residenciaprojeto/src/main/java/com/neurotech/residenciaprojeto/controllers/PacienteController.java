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

import com.neurotech.residenciaprojeto.entities.Paciente;
import com.neurotech.residenciaprojeto.repositories.PacienteRepository;

@RestController
@RequestMapping(value = "/paciente")
public class PacienteController {

	@Autowired
	private PacienteRepository repository;

	@GetMapping
	public Page<Paciente> findAll(Pageable pageable) {
		Page<Paciente> result = repository.findAll(pageable);
		return result;
	}
	@GetMapping(value = "/{id}")
	public Paciente findById(@PathVariable Long id) {
		Paciente result = repository.findById(id).get();
		return result;
	}
	@PostMapping
	public Paciente insert(@RequestBody Paciente paciente) {
		Paciente result = repository.save(paciente);
		return result;
	}
	@DeleteMapping(value = "/delete-{id}")
	public void deleteById(@PathVariable Long id) {
		repository.deleteById(id);
	}
	@PutMapping(value = "/update-{id}")
	public ResponseEntity<Paciente>  updateUser(@PathVariable Long id, @RequestBody Paciente paciente) {
		Paciente newPaciente = repository.findById(id).get();
		newPaciente.setEmail(paciente.getEmail());
		newPaciente.setTelefone(paciente.getTelefone());
		repository.save(newPaciente);
		return ResponseEntity.ok(newPaciente);
	}
}
