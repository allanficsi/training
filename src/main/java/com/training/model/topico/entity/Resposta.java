package com.training.model.topico.entity;

import com.training.model.usuario.entity.Usuario;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "SC_TPC", name = "TBL_RSP")
public class Resposta implements Serializable
{

	private static final long serialVersionUID = 7288675933807133457L;
	@Id
	@Column(name = "CD_RSP")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RSP")
	@SequenceGenerator(name = "SQ_RSP", sequenceName = "SC_RSP.SQ_RSP")
	private Long codigo;

	@Column(name = "RSP_MSG")
	private String mensagem;

	@Column(name = "CD_TPC")
	private Long codigoDoTopico;

	@ManyToOne
	@JoinColumn(name = "CD_TPC", insertable = false, updatable = false)
	private Topico topico;

	@Column(name = "CD_USR")
	private Long codigoDoUsuario;

	@ManyToOne
	@JoinColumn(name = "CD_USR", insertable = false, updatable = false)
	private Usuario autor;

	@Column(name = "DT_CRC")
	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Column(name = "RSP_SOLUCAO")
	private Boolean isSolucao = false;

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
		Resposta other = (Resposta) obj;
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

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Long getCodigoDoTopico() {
		return codigoDoTopico;
	}

	public void setCodigoDoTopico(Long codigoDoTopico) {
		this.codigoDoTopico = codigoDoTopico;
	}

	public Topico getTopico() {
		return topico;
	}

	public void setTopico(Topico topico) {
		this.topico = topico;
	}

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

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Boolean getSolucao() {
		return isSolucao;
	}

	public void setSolucao(Boolean solucao) {
		isSolucao = solucao;
	}
}
