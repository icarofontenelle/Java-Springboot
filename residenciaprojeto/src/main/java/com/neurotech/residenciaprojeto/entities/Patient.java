package com.neurotech.residenciaprojeto.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name ="tb_patient")
@SQLDelete(sql = "UPDATE tb_patient SET deleted = true WHERE id=?")
@Where(clause = "deleted= false")
public class Patient  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String password;
	private String cpf;
	private String address;
	private String phone;
	private String email;
	
	private boolean deleted;

	@OneToMany(mappedBy = "patient")
	private List<Appointment> Appointments = new ArrayList<>();
	
	public Patient() {
		
	}

	public Patient(Long id, String name, String password, String cpf, String address, String phone, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.cpf = cpf;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.deleted = Boolean.FALSE;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public boolean isDeleted() {
		return deleted;
	}
	
	public List<Appointment> getAppointments() {
		return Appointments;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
}
