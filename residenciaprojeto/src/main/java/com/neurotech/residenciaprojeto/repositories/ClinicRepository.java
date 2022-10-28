package com.neurotech.residenciaprojeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neurotech.residenciaprojeto.entities.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {

}
