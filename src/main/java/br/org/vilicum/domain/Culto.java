package br.org.vilicum.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.org.vilicum.util.BaseEntity;

@Entity
public class Culto implements BaseEntity, Serializable, Comparable<Culto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8836631181142699768L;

	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long idCulto;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idPastor", nullable=true) 
	private Pastor pastor;
	
	@Column
	private boolean diacono;
	
	@Column
	private String nomeDiacono;
	
	@Column
	private String programa;
	
	@Column
	private Integer adultos;

	@Column
	private Integer criancas;

	@Column
	private Integer visitantes;
	
	@Column
	private Integer participantes;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idCon")
	private Congregacao congregacao;
	
	@ManyToMany
	@JoinTable(name="santaceia", joinColumns=@JoinColumn(name="idCulto"), inverseJoinColumns=@JoinColumn(name="idMembro"))
	private List<Membro> santaceia;

	public Long getIdCulto() {
		return idCulto;
	}

	public void setIdCulto(Long idCulto) {
		this.idCulto = idCulto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Pastor getPastor() {
		return pastor;
	}

	public void setPastor(Pastor pastor) {
		this.pastor = pastor;
	}

	public boolean isDiacono() {
		return diacono;
	}

	public void setDiacono(boolean diacono) {
		this.diacono = diacono;
	}

	public String getNomeDiacono() {
		return nomeDiacono;
	}

	public void setNomeDiacono(String nomeDiacono) {
		this.nomeDiacono = nomeDiacono;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public Integer getAdultos() {
		return adultos;
	}

	public void setAdultos(Integer adultos) {
		this.adultos = adultos;
	}

	public Integer getCriancas() {
		return criancas;
	}

	public void setCriancas(Integer criancas) {
		this.criancas = criancas;
	}

	public Integer getVisitantes() {
		return visitantes;
	}

	public void setVisitantes(Integer visitantes) {
		this.visitantes = visitantes;
	}

	public Integer getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Integer participantes) {
		this.participantes = participantes;
	}

	public Congregacao getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}

	@Override
	public Long getId() {
		return this.idCulto;
	}

//	public void setParticipacoes(List<Participacao> santaceia) {
//		this.participacoes = santaceia;
//	}
//
//	public List<Participacao> getParticipacoes() {
//		if (santaceia == null) {
//			santaceia = new ArrayList<Participacao>();
//		}
//		return santaceia;
//	}
	
	@Override
	public int compareTo(Culto o) {
	    final int IGUAL = 0;
	    
	    if (o == null) {
	    	return -1;
	    }
	    
		if (this == o) {
			return IGUAL;
		}
		
		if (this.data != null) {
			int comp = this.data.compareTo(o.getData());
			if (comp != IGUAL) {
				return comp;
			}
		}
		
		if (this.congregacao != null && o.getCongregacao() != null) {
			int comp = this.congregacao.compareTo(o.getCongregacao());
			if (comp != IGUAL) {
				return comp;
			}
		}
		
		return IGUAL;
	}

	@Override
	public String toString() {
		return "Culto " + this.idCulto + " Congregacao " + this.congregacao + " Data " + this.data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adultos == null) ? 0 : adultos.hashCode());
		result = prime * result
				+ ((congregacao == null) ? 0 : congregacao.hashCode());
		result = prime * result
				+ ((criancas == null) ? 0 : criancas.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + (diacono ? 1231 : 1237);
		result = prime * result + ((idCulto == null) ? 0 : idCulto.hashCode());
		result = prime * result
				+ ((nomeDiacono == null) ? 0 : nomeDiacono.hashCode());
//		result = prime * result
//				+ ((santaceia == null) ? 0 : santaceia.hashCode());
		result = prime * result
				+ ((participantes == null) ? 0 : participantes.hashCode());
		result = prime * result + ((pastor == null) ? 0 : pastor.hashCode());
		result = prime * result
				+ ((programa == null) ? 0 : programa.hashCode());
		result = prime * result
				+ ((visitantes == null) ? 0 : visitantes.hashCode());
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
		Culto other = (Culto) obj;
		if (adultos == null) {
			if (other.adultos != null)
				return false;
		} else if (!adultos.equals(other.adultos))
			return false;
		if (congregacao == null) {
			if (other.congregacao != null)
				return false;
		} else if (!congregacao.equals(other.congregacao))
			return false;
		if (criancas == null) {
			if (other.criancas != null)
				return false;
		} else if (!criancas.equals(other.criancas))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (diacono != other.diacono)
			return false;
		if (idCulto == null) {
			if (other.idCulto != null)
				return false;
		} else if (!idCulto.equals(other.idCulto))
			return false;
		if (nomeDiacono == null) {
			if (other.nomeDiacono != null)
				return false;
		} else if (!nomeDiacono.equals(other.nomeDiacono))
			return false;
//		if (santaceia == null) {
//			if (other.participacoes != null)
//				return false;
//		} else if (!santaceia.equals(other.participacoes))
//			return false;
		if (participantes == null) {
			if (other.participantes != null)
				return false;
		} else if (!participantes.equals(other.participantes))
			return false;
		if (pastor == null) {
			if (other.pastor != null)
				return false;
		} else if (!pastor.equals(other.pastor))
			return false;
		if (programa == null) {
			if (other.programa != null)
				return false;
		} else if (!programa.equals(other.programa))
			return false;
		if (visitantes == null) {
			if (other.visitantes != null)
				return false;
		} else if (!visitantes.equals(other.visitantes))
			return false;
		return true;
	}

	public List<Membro> getSantaceia() {
		return santaceia;
	}

	public void setSantaceia(List<Membro> participacoes) {
		this.santaceia = participacoes;
	}
	
	public int getQtdStaCeia() {
		int q = 0;
		
		if (this.santaceia != null) {
			q = this.santaceia.size();
		}
		
		return q;
	}
	
}
