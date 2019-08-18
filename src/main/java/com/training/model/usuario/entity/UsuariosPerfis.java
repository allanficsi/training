package com.training.model.usuario.entity;

import com.training.model.usuario.entity.pk.UsuariosPerfisPk;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(schema = "SC_SGR", name = "TBL_USR_SGR")
public class UsuariosPerfis implements Serializable
{

//	@Id
//	@Column(name = "CD_USR_PRF")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USR_PRF")
//	@SequenceGenerator(name = "SQ_USR_PRF", sequenceName = "SC_USR.SQ_USR_PRF")
//	private Long codigo;

	@EmbeddedId
	private UsuariosPerfisPk nome;

	@ManyToOne
	@MapsId("CD_USR")
	@JoinColumn(name = "CD_USR")
	private Usuario usuario;

	@ManyToOne
	@MapsId("CD_SGR")
	@JoinColumn(name = "CD_SGR")
	private Perfil perfil;


	public UsuariosPerfis() {

	}

	public UsuariosPerfisPk getNome()
	{
		return nome;
	}

	public void setNome(UsuariosPerfisPk nome)
	{
		this.nome = nome;
	}

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}

	public Perfil getPerfil()
	{
		return perfil;
	}

	public void setPerfil(Perfil perfil)
	{
		this.perfil = perfil;
	}
}
