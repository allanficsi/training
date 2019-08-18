package com.training.model.usuario.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * o spring obriga vc a ter uma classe que representa
 * um usuario para isso é nescessario implementar a interface UserDetail
 */

@Entity
@Table(schema = "SC_SGR", name = "TBL_USR")
public class Usuario implements Serializable
{

	private static final long serialVersionUID = 1764129583839356571L;
	@Id
	@Column(name = "CD_USR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USR")
	@SequenceGenerator(name = "SQ_USR", sequenceName = "SC_SGR.SQ_USR", allocationSize = 1)
	private Long codigo;

	@Column(name = "USR_NOME")
	private String nome;

	@Column(name = "USR_EMAIL")
	private String email;

	@Column(name = "USR_SENHA")
	private String senha;

	@OneToMany(mappedBy = "usuario" , fetch = FetchType.EAGER)
	private Set<UsuariosPerfis>  usuariosPerfis;

	public Usuario() {
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
		Usuario other = (Usuario) obj;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<UsuariosPerfis> getUsuariosPerfis()
	{
		return usuariosPerfis;
	}

	public void setUsuariosPerfis(Set<UsuariosPerfis> usuariosPerfis)
	{
		this.usuariosPerfis = usuariosPerfis;
	}


}
