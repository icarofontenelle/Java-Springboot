package com.neurotech.residenciaprojeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neurotech.residenciaprojeto.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
