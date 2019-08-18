package com.training.model.usuario.dto;

import java.io.Serializable;


public class UsuariosPerfisDTO implements Serializable
{
    private Long codigoUsuario;

    private Long codigoPerfil;

    private UsuarioDTO usuario;

    private PerfilDTO perfil;


	public Long getCodigoUsuario()
	{
		return codigoUsuario;
	}

	public void setCodigoUsuario(Long codigoUsuario)
	{
		this.codigoUsuario = codigoUsuario;
	}

	public Long getCodigoPerfil()
	{
		return codigoPerfil;
	}

	public void setCodigoPerfil(Long codigoPerfil)
	{
		this.codigoPerfil = codigoPerfil;
	}

	public UsuarioDTO getUsuario()
	{
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario)
	{
		this.usuario = usuario;
	}

	public PerfilDTO getPerfil()
	{
		return perfil;
	}

	public void setPerfil(PerfilDTO perfil)
	{
		this.perfil = perfil;
	}
}
