package com.training.model.curso.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "SC_CRS", name = "TBL_CRS")
public class Curso implements Serializable
{

	private static final long serialVersionUID = -6684086083615806304L;
	@Id
	@Column(name = "CD_CRS")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CRS")
	@SequenceGenerator(name = "SQ_CRS", sequenceName = "SC_CRS.SQ_CRS")
	private Long codigo;

	@Column(name = "CRS_NOME")
	private String nome;

	@Column(name = "CRS_CATEGORIA")
	private String categoria;

	public Curso() {
	}

	public Curso(String nome, String categoria) {
		this.nome = nome;
		this.categoria = categoria;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Curso other = (Curso) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
