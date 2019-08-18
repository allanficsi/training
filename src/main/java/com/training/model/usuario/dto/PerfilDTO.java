package com.training.model.usuario.dto;

import java.util.Set;


public class PerfilDTO
{
	private Long codigo;

	private String role;

	private Set<UsuariosPerfisDTO> usuariosPerfis;

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

	public Set<UsuariosPerfisDTO> getUsuariosPerfis()
	{
		return usuariosPerfis;
	}

	public void setUsuariosPerfis(Set<UsuariosPerfisDTO> usuariosPerfis)
	{
		this.usuariosPerfis = usuariosPerfis;
	}
}
