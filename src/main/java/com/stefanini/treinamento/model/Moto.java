package com.stefanini.treinamento.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="moto")
public class Moto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SQ_id_moto", sequenceName = "SQ_id_moto", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SQ_id_moto")
	@Column(name="id_moto")
	private Long id_moto;
	
	@NotNull
	@Column(name="nome", length=20)
	private String nome;
   
	@Size(min=1, max=5)
	@OneToMany(mappedBy = "id_moto",fetch = FetchType.LAZY,
	cascade= {CascadeType.ALL},orphanRemoval=true)
	private List<Capacete> capacetes;

	public Long getId_moto() {
		return id_moto;
	}

	public void setId_moto(Long id_moto) {
		this.id_moto = id_moto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Capacete> getCapacetes() {
		return capacetes;
	}

	public void setCapacetes(List<Capacete> capacetes) {
		this.capacetes = capacetes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_moto == null) ? 0 : id_moto.hashCode());
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
		Moto other = (Moto) obj;
		if (id_moto == null) {
			if (other.id_moto != null)
				return false;
		} else if (!id_moto.equals(other.id_moto))
			return false;
		return true;
	}

	public Moto(Long id_moto, @NotNull String nome, @Size(min = 1, max = 5) List<Capacete> capacetes) {
		super();
		this.id_moto = id_moto;
		this.nome = nome;
		this.capacetes = capacetes;
	}

	public Moto() {
		super();
	}
	
	
	
	
	

}
