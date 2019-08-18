package com.training.model.topico.dto;

import com.training.model.usuario.dto.UsuarioDTO;

import java.time.LocalDateTime;

public class RespostaDTO {

	private Long id;
	private String mensagem;
	private TopicoDTO topico;
	private LocalDateTime dataCriacao;
	private UsuarioDTO autor;
	private Boolean solucao;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public TopicoDTO getTopico() {
		return topico;
	}

	public void setTopico(TopicoDTO topico) {
		this.topico = topico;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public UsuarioDTO getAutor() {
		return autor;
	}

	public void setAutor(UsuarioDTO autor) {
		this.autor = autor;
	}

	public Boolean getSolucao() {
		return solucao;
	}

	public void setSolucao(Boolean solucao) {
		this.solucao = solucao;
	}

}
