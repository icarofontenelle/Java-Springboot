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

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "tb_doctor")
@SQLDelete(sql = "UPDATE tb_doctor SET deleted = true WHERE id=?")
@Where(clause = "deleted= false")
public class Doctor  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String crm;
	private String phone;
	private String email;
	
	private boolean deleted;

	@ManyToOne
	@JoinColumn(name = "clinic_id")
	private Clinic clinic;
	
	@OneToMany(mappedBy = "doctor")
	private List<Agenda> Agendas = new ArrayList<>();
	
	public Doctor() {

	}

	public Doctor(Long id, String name, String crm, String phone, String email, Clinic clinic) {
		this.id = id;
		this.name = name;
		this.crm = crm;
		this.phone = phone;
		this.email = email;
		this.clinic = clinic;
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
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public List<Agenda> getAgendas() {
		return Agendas;
	}
}
