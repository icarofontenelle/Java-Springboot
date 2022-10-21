package com.neurotech.residenciaprojeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neurotech.residenciaprojeto.entities.Medico;
import com.neurotech.residenciaprojeto.entities.Paciente;
import com.neurotech.residenciaprojeto.repositories.MedicoRepository;
import com.neurotech.residenciaprojeto.repositories.PacienteRepository;

@RestController
@RequestMapping(value = "/medico")
public class MedicoController {

	@Autowired
	private MedicoRepository repository;
	
	@Autowired
	private PacienteRepository pRepository;

	@GetMapping
	public Page<Medico> findAll(Pageable pageable) {
		Page<Medico> result = repository.findAll(pageable);
		return result;
	}
	@GetMapping(value = "/{id}")
	public Medico findById(@PathVariable Long id) {
		Medico result = repository.findById(id).get();
		return result;
	}
	@PostMapping
	public Medico insert(@RequestBody Medico medico) {
		Medico result = repository.save(medico);
		return result;
	}
	@DeleteMapping(value = "/delete-{id}")
	public void deleteById(@PathVariable Long id) {
		repository.deleteById(id);
	}

	@PutMapping("/{medicoId}/paciente/{pacienteId}")
		Medico assignPacienteToMedico(@PathVariable Long medicoId,@PathVariable Long pacienteId ) {
        Medico medico = repository.findById(medicoId).get();
        Paciente paciente = pRepository.findById(pacienteId).get();
        medico.pacientes(paciente);
        return repository.save(medico);
	}
}
