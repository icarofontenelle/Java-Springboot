package com.neurotech.residenciaprojeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neurotech.residenciaprojeto.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
