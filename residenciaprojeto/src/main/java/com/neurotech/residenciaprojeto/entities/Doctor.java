package com.neurotech.residenciaprojeto.entities;

import java.io.Serializable;
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

@Entity
@Table(name = "tb_doctor")
public class Doctor  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String crm;
	private String phone;
	private String email;

	@ManyToOne
	@JoinColumn(name = "clinic_id")
	private Clinic clinic;

	@OneToMany(mappedBy = "doctor")
	private List<Patient> patients = new ArrayList<>();

	public Doctor() {

	}

	public Doctor(Long id, String name, String crm, String phone, String email, Clinic clinic) {
		this.id = id;
		this.name = name;
		this.crm = crm;
		this.phone = phone;
		this.email = email;
		this.clinic = clinic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public List<Patient> getPatients() {
		return patients;
	}
	
}
