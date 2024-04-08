package com.assetbox.api.modelos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emp_id;
	
	@Column
	private String emp_nome;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Endereco emp_endereco_id;

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_nome() {
		return emp_nome;
	}

	public void setEmp_nome(String emp_nome) {
		this.emp_nome = emp_nome;
	}

	public Endereco getEmp_endereco_id() {
		return emp_endereco_id;
	}

	public void setEmp_endereco_id(Endereco emp_endereco_id) {
		this.emp_endereco_id = emp_endereco_id;
	}
	
	
}
