package com.neurotech.residenciaprojeto.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.neurotech.residenciaprojeto.entities.PK.AgendaPK;

@Entity
@Table(name = "tb_agenda")
public class Agenda  implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AgendaPK id = new AgendaPK();
	
	private LocalDateTime time;
	
	public Agenda() {
		
	}

	public Agenda(Doctor doctor, Patient patient, LocalDateTime time) {
		id.setDoctor(doctor);
		id.setPatient(patient);
		this.time = time;
	}
	
	public Doctor getDoctor() {
		return id.getDoctor();
	}
	
	public void setOrder(Doctor doctor) {
		id.setDoctor(doctor);
	}
	
	public Patient  getPatient() {
		return id.getPatient();
	}
	
	public void setProduct(Patient patient) {
		id.setPatient(patient);
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
}
