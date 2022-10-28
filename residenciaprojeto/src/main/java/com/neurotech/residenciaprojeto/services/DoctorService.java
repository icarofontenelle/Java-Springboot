package com.neurotech.residenciaprojeto.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.neurotech.residenciaprojeto.entities.Doctor;
import com.neurotech.residenciaprojeto.repositories.DoctorRepository;
import com.neurotech.residenciaprojeto.services.exceptions.DatabaseException;
import com.neurotech.residenciaprojeto.services.exceptions.ResourceNotFoundException;

@Service
public class DoctorService {

	@Autowired
	DoctorRepository repository ;

	public Page<Doctor> findAll(Pageable pageable) {
		Page<Doctor> result = repository.findAll(pageable);
		return result;
	}
	
	public Doctor findById(Long id) {
		Optional<Doctor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Doctor insert(Doctor obj) {
		 return repository.save(obj);
	}
	
	public Doctor update (Long id, Doctor obj) {
		try {
			Doctor entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);	
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
			}
	}
	
	private void updateData(Doctor entity, Doctor obj) {
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		entity.setClinic(obj.getClinic());
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
