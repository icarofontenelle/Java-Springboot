package com.neurotech.residenciaprojeto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_appointment")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
	private Time time_;
	
	public Appointment() {
		
	}

	public Appointment(Long id, Patient patient, Time time_) {
		this.id = id;
		this.patient = patient;
		this.time_ = time_;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Time getTime_agenda() {
		return time_;
	}

	public void setTime_agenda(Time time_) {
		this.time_ = time_;
	}
	
}
