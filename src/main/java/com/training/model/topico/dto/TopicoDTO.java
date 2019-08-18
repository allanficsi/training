package com.training.model.topico.dto;

import com.training.model.curso.dto.CursoDTO;
import com.training.model.usuario.dto.UsuarioDTO;
import java.time.LocalDateTime;
import java.util.Set;

public class TopicoDTO {

	private Long codigo;

	private String titulo;

	private String mensagem;

	private LocalDateTime dataCriacao;

	private String status;

	private Long codigoDoUsuario;

	private UsuarioDTO autor;

	private Long codidoDoCurso;

	private CursoDTO curso;

	private Set<RespostaDTO> respostas;

	public Long getCodigo() {
		return codigo;
	}

	int totalPages;

	long totalElements;

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCodigoDoUsuario() {
		return codigoDoUsuario;
	}

	public void setCodigoDoUsuario(Long codigoDoUsuario) {
		this.codigoDoUsuario = codigoDoUsuario;
	}

	public UsuarioDTO getAutor() {
		return autor;
	}

	public void setAutor(UsuarioDTO autor) {
		this.autor = autor;
	}

	public Long getCodidoDoCurso() {
		return codidoDoCurso;
	}

	public void setCodidoDoCurso(Long codidoDoCurso) {
		this.codidoDoCurso = codidoDoCurso;
	}

	public CursoDTO getCurso() {
		return curso;
	}

	public void setCurso(CursoDTO curso) {
		this.curso = curso;
	}

	public Set<RespostaDTO> getRespostas() {
		return respostas;
	}

	public void setRespostas(Set<RespostaDTO> respostas) {
		this.respostas = respostas;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
}
