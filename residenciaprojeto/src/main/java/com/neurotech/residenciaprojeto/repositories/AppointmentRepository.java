package com.neurotech.residenciaprojeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neurotech.residenciaprojeto.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
