package com.training.model.usuario.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

/**
 * a classe perfil sao as roles do usuario tipo ADM,USER, ela deve emplementar
 * a interface GrantedAuthority e a classe que emplementa USERDETAIL
 * deve possuir uma lista dessas permissoes
 */
@Entity
@Table(schema = "SC_SGR", name = "TBL_SGR")
public class Perfil implements GrantedAuthority
{

	@Id
	@Column(name = "CD_SGR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SGR")
	@SequenceGenerator(name = "SQ_SGR", sequenceName = "SC_USR.SQ_USR", allocationSize = 1)
	private Long codigo;

	@Column(name = "DSC_ROLE")
	private String role;

	@OneToMany(mappedBy = "perfil")
	private Set<UsuariosPerfis> usuariosPerfis;

	public Perfil() {
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
		Perfil other = (Perfil) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public Long getCodigo()
	{
		return codigo;
	}

	public void setCodigo(Long codigo)
	{
		this.codigo = codigo;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public Set<UsuariosPerfis> getUsuariosPerfis()
	{
		return usuariosPerfis;
	}

	public void setUsuariosPerfis(Set<UsuariosPerfis> usuariosPerfis)
	{
		this.usuariosPerfis = usuariosPerfis;
	}

	@Override
	public String getAuthority()
	{
		return this.role;
	}
}
