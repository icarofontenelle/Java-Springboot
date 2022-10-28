package com.neurotech.residenciaprojeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neurotech.residenciaprojeto.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
