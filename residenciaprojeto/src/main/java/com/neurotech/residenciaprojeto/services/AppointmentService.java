package com.neurotech.residenciaprojeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.neurotech.residenciaprojeto.entities.Appointment;
import com.neurotech.residenciaprojeto.repositories.AppointmentRepository;
import com.neurotech.residenciaprojeto.services.exceptions.DatabaseException;
import com.neurotech.residenciaprojeto.services.exceptions.ResourceNotFoundException;

@Service
public class AppointmentService {

	@Autowired
	AppointmentRepository repository ;

	public Page<Appointment> findAll(Pageable pageable) {
		Page<Appointment> result = repository.findAll(pageable);
		return result;
	}
	
	public Appointment findById(Long id) {
		Optional<Appointment> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Appointment insert(Appointment obj) {
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
	
	/*
	public Appointment update (Long id, Appointment obj) {
		try {
			Appointment entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);	
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(Appointment entity, Appointment obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());	
	}
	*/
}
