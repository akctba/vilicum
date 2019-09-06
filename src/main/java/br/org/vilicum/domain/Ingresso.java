package br.org.vilicum.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.org.vilicum.util.BaseEntity;
import br.org.vilicum.util.CustomDate;

@Entity
public class Ingresso implements BaseEntity, Serializable {

	private static final long serialVersionUID = 301089441420007601L;

	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long idIngresso;
	
	public Ingresso() {
		super();
	}
	
	public Ingresso(String forma) {
		super();
		this.forma = forma;
	}

	@Column
	private String forma;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date cadastro;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date exclusao;
	
	public Long getIdIngresso() {
		return idIngresso;
	}

	public void setIdIngresso(Long idIngresso) {
		this.idIngresso = idIngresso;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public Date getAlteracao() {
		return alteracao;
	}

	public void setAlteracao(Date alteracao) {
		this.alteracao = alteracao;
	}
	
	public void setExclusao(Date exclusao) {
		this.exclusao = exclusao;
	}

	public Date getExclusao() {
		return exclusao;
	}

	@PrePersist
	void preInsert() {
		if(this.cadastro == null) {
			this.cadastro = CustomDate.getCurrentDate();
		} else {
			this.alteracao = CustomDate.getCurrentDate();
		}
	}

	@Override
	public Long getId() {
		return this.idIngresso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alteracao == null) ? 0 : alteracao.hashCode());
		result = prime * result
				+ ((cadastro == null) ? 0 : cadastro.hashCode());
		result = prime * result
				+ ((exclusao == null) ? 0 : exclusao.hashCode());
		result = prime * result + ((forma == null) ? 0 : forma.hashCode());
		result = prime * result
				+ ((idIngresso == null) ? 0 : idIngresso.hashCode());
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
		Ingresso other = (Ingresso) obj;
		if (alteracao == null) {
			if (other.alteracao != null)
				return false;
		} else if (!alteracao.equals(other.alteracao))
			return false;
		if (cadastro == null) {
			if (other.cadastro != null)
				return false;
		} else if (!cadastro.equals(other.cadastro))
			return false;
		if (exclusao == null) {
			if (other.exclusao != null)
				return false;
		} else if (!exclusao.equals(other.exclusao))
			return false;
		if (forma == null) {
			if (other.forma != null)
				return false;
		} else if (!forma.equals(other.forma))
			return false;
		if (idIngresso == null) {
			if (other.idIngresso != null)
				return false;
		} else if (!idIngresso.equals(other.idIngresso))
			return false;
		return true;
	}
	
	
}
