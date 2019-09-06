package br.org.vilicum.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.org.vilicum.util.BaseEntity;

@Entity
public class Departamento implements BaseEntity, Serializable, Comparable<Departamento> {

	private static final long serialVersionUID = -6216564432964423403L;

	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long idDep;
	
	@Column
	private String nome;
	
	@ManyToOne
	private Congregacao congregacao;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date termino;

	public Long getIdDep() {
		return idDep;
	}

	public void setIdDep(Long idDep) {
		this.idDep = idDep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Congregacao getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((congregacao == null) ? 0 : congregacao.hashCode());
		result = prime * result + ((idDep == null) ? 0 : idDep.hashCode());
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Departamento other = (Departamento) obj;
		if (congregacao == null) {
			if (other.congregacao != null)
				return false;
		} else if (!congregacao.equals(other.congregacao))
			return false;
		if (idDep == null) {
			if (other.idDep != null)
				return false;
		} else if (!idDep.equals(other.idDep))
			return false;
		if (inicio == null) {
			if (other.inicio != null)
				return false;
		} else if (!inicio.equals(other.inicio))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public int compareTo(Departamento o) {
		final int IGUAL = 0;
		final int ANTES = -1;
		final int DEPOIS = 1;
	    
	    if (o == null) {
	    	return -1;
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
		
		String nomeToCompare = (this.nome!=null?this.nome:"");
		
		return nomeToCompare.compareTo(o.getNome());
		
	}

	@Override
	public Long getId() {
		return this.idDep;
	}
	
	
}
