package com.stefanini.treinamento.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "capacete")
public class Capacete implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SQ_id_capacete", sequenceName = "SQ_id_capacete", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_id_capacete")
	@Column(name = "id_capacete", length = 5)
	private Long id_capacete;

	@Column(name = "descricao", length = 20)
	private String descricao;
	
	@Column(name = "id_moto")
	private Long id_moto;
	
	public Long getId_capacete() {
		return id_capacete;
	}
	public void setId_capacete(Long id_capacete) {
		this.id_capacete = id_capacete;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getId_moto() {
		return id_moto;
	}
	public void setId_moto(Long id_moto) {
		this.id_moto = id_moto;
	}
	public Capacete(Long id_capacete, String descricao, Long id_moto) {
		super();
		this.id_capacete = id_capacete;
		this.descricao = descricao;
		this.id_moto = id_moto;
	}
	public Capacete() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_capacete == null) ? 0 : id_capacete.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Capacete other = (Capacete) obj;
		if (id_capacete == null) {
			if (other.id_capacete != null)
				return false;
		} else if (!id_capacete.equals(other.id_capacete))
			return false;
		return true;
	}
	

	
}
