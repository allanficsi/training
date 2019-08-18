package com.training.model.usuario.dto;

import java.io.Serializable;
import java.util.Set;

public class UsuarioDTO implements Serializable {

	private Long codigo;
	private String nome;
	private String email;
	private String senha;
	private Set<UsuariosPerfisDTO> authorities;

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

	public Set<UsuariosPerfisDTO> getAuthorities()
	{
		return authorities;
	}

	public void setAuthorities(Set<UsuariosPerfisDTO> authorities)
	{
		this.authorities = authorities;
	}
}
