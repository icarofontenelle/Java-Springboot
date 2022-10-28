package com.neurotech.residenciaprojeto.services;


import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.neurotech.residenciaprojeto.entities.Clinic;
import com.neurotech.residenciaprojeto.repositories.ClinicRepository;
import com.neurotech.residenciaprojeto.services.exceptions.DatabaseException;
import com.neurotech.residenciaprojeto.services.exceptions.ResourceNotFoundException;

@Service
public class ClinicService {

	@Autowired
	ClinicRepository repository ;

	
	public Page<Clinic> findAll(Pageable pageable) {
		Page<Clinic> result = repository.findAll(pageable);
		return result;
	}
	
	public Clinic findById(Long id) {
		Optional<Clinic> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Clinic insert(Clinic obj) {
		 return repository.save(obj);
	}
	
	public Clinic update (Long id, Clinic obj) {
		try {
			Clinic entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);	
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Clinic entity, Clinic obj) {;
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
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
}
