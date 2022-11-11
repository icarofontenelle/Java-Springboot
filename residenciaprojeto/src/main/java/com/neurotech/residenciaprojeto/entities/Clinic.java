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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_clinic")
@SQLDelete(sql = "UPDATE tb_clinic SET deleted = true WHERE id=?")
@Where(clause = "deleted= false")
public class Clinic  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String cnpj;
	private String phone;
	private String email;
	private String address;

	private boolean deleted;

	@JsonIgnore
	@OneToMany(mappedBy = "clinic")
	private List<Doctor> doctors = new ArrayList<>();

	public Clinic() {

	}

	public Clinic(Long id, String name, String cnpj, String phone, String email, String address) {
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.phone = phone;
		this.email = email;
		this.address = address;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
