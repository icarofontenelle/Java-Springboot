package com.neurotech.residenciaprojeto.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.neurotech.residenciaprojeto.entities.Patient;
import com.neurotech.residenciaprojeto.repositories.PatientRepository;
import com.neurotech.residenciaprojeto.services.exceptions.DatabaseException;
import com.neurotech.residenciaprojeto.services.exceptions.ResourceNotFoundException;

@Service
public class PatientService {

	@Autowired
	PatientRepository repository ;

	public Page<Patient> findAll(Pageable pageable) {
		Page<Patient> result = repository.findAll(pageable);
		return result;
	}
	
	public Patient findById(Long id) {
		Optional<Patient> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Patient insert(Patient obj) {
		 return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);	
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public Patient update (Long id, Patient obj) {
		try {
			Patient entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);	
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(Patient entity, Patient obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
