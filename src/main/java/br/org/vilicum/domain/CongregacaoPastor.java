package br.org.vilicum.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.org.vilicum.util.BaseEntity;

@Entity
public class CongregacaoPastor implements BaseEntity, Serializable, Comparable<CongregacaoPastor> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6033028618793345558L;
	
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long idCp;

	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="idCon", nullable=true) 
	private Congregacao congregacao;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="idPastor", nullable=true) 
	private Pastor pastor;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date entrada;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date saida;

	public Congregacao getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}

	public Pastor getPastor() {
		return pastor;
	}

	public void setPastor(Pastor pastor) {
		this.pastor = pastor;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

	public void setIdCp(Long idCp) {
		this.idCp = idCp;
	}

	public Long getIdCp() {
		return idCp;
	}

	@Override
	public Long getId() {
		return this.idCp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((congregacao == null) ? 0 : congregacao.hashCode());
		result = prime * result + ((entrada == null) ? 0 : entrada.hashCode());
		result = prime * result + ((idCp == null) ? 0 : idCp.hashCode());
		result = prime * result + ((pastor == null) ? 0 : pastor.hashCode());
		result = prime * result + ((saida == null) ? 0 : saida.hashCode());
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
		CongregacaoPastor other = (CongregacaoPastor) obj;
		if (congregacao == null) {
			if (other.congregacao != null)
				return false;
		} else if (!congregacao.equals(other.congregacao))
			return false;
		if (entrada == null) {
			if (other.entrada != null)
				return false;
		} else if (!entrada.equals(other.entrada))
			return false;
		if (idCp == null) {
			if (other.idCp != null)
				return false;
		} else if (!idCp.equals(other.idCp))
			return false;
		if (pastor == null) {
			if (other.pastor != null)
				return false;
		} else if (!pastor.equals(other.pastor))
			return false;
		if (saida == null) {
			if (other.saida != null)
				return false;
		} else if (!saida.equals(other.saida))
			return false;
		return true;
	}

	@Override
	public int compareTo(CongregacaoPastor o) {
		final int IGUAL = 0;
		final int ANTES = -1;
		final int DEPOIS = 1;
	    
	    if (o == null) {
	    	return ANTES;
	    }
	    
		if (this == o) {
			return IGUAL;
		}
		
		long difCong = 0L;
		if (this.getCongregacao() != null && o.getCongregacao() != null) {
			difCong = (this.getCongregacao().getId() - o.getCongregacao().getId());
		} else if (this.getCongregacao() == null) {
			difCong = ANTES;
		} else {
			difCong = DEPOIS;
		}
		
		if (difCong != IGUAL) {
			return (difCong > IGUAL ? DEPOIS : ANTES);
		}
		
		// se for a mesma congregação, desempata com o pastor
		
		long difPastor = 0L;
		if (this.getPastor() != null && o.getPastor() != null) {
			difPastor = (this.getPastor().getId() - o.getPastor().getId());
		} else if (this.getPastor() == null) {
			difPastor = ANTES;
		} else {
			difPastor = DEPOIS;
		}
		
		return (difPastor > IGUAL ? DEPOIS : ANTES);
		
	}
	
	

	
	
}
