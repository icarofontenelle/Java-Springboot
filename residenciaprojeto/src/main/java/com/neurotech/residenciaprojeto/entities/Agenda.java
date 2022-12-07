package com.neurotech.residenciaprojeto.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_agenda")
public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss'")
	private LocalDateTime start_validity;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss'")
	private LocalDateTime end_validity;
	
	@OneToMany(mappedBy = "agenda")
	private List<Time> timers_agenda = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	public Agenda() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getStart_validity() {
		return start_validity;
	}

	public void setStart_validity(LocalDateTime start_validity) {
		this.start_validity = start_validity;
	}

	public LocalDateTime getEnd_validity() {
		return end_validity;
	}

	public void setEnd_validity(LocalDateTime end_validity) {
		this.end_validity = end_validity;
	}

	public List<Time> getTimers_agenda() {
		return timers_agenda;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
	
}
