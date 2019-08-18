package com.training.model.topico.entity;

import com.training.model.curso.entity.Curso;
import com.training.model.usuario.entity.Usuario;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "SC_TPC", name = "TBL_TPC")
public class Topico implements Serializable
{

	private static final long serialVersionUID = -6601028723002783441L;
	@Id
	@Column(name = "CD_TPC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TPC")
	@SequenceGenerator(name = "SQ_TPC", sequenceName = "SC_TPC.SQ_TPC", allocationSize = 1)
	private Long codigo;

	@NotNull @NotEmpty
	@Column(name = "TPC_TTL")
	private String titulo;

	@NotNull @NotEmpty
	@Column(name = "TPC_MSG")
	private String mensagem;

	@Column(name = "DT_CRC")
	private LocalDateTime dataCriacao = LocalDateTime.now();

//	@Column(name = "STT_TPC")
//	@Enumerated(EnumType.STRING)
//	private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

	@Column(name = "CD_USR")
	private Long codigoDoUsuario;

	@ManyToOne
	@JoinColumn(name = "CD_USR", insertable = false, updatable = false)
	private Usuario autor;

	@Column(name = "CD_CRS")
	private Long codidoDoCurso;

	@ManyToOne
	@JoinColumn(name = "CD_USR", insertable = false, updatable = false)
	private Curso curso;


	@OneToMany(mappedBy = "topico")
	private Set<Resposta> respostas = new HashSet<>();

	public Topico() {
	}

	public Topico(String titulo, String mensagem, Curso curso) {
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.curso = curso;
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
		Topico other = (Topico) obj;
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

//	public StatusTopico getStatus() {
//		return status;
//	}
//
//	public void setStatus(StatusTopico status) {
//		this.status = status;
//	}

	public Long getCodigoDoUsuario() {
		return codigoDoUsuario;
	}

	public void setCodigoDoUsuario(Long codigoDoUsuario) {
		this.codigoDoUsuario = codigoDoUsuario;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Long getCodidoDoCurso() {
		return codidoDoCurso;
	}

	public void setCodidoDoCurso(Long codidoDoCurso) {
		this.codidoDoCurso = codidoDoCurso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Set<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(Set<Resposta> respostas) {
		this.respostas = respostas;
	}
}
