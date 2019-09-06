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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;

import br.org.vilicum.util.BaseEntity;
import br.org.vilicum.util.CustomDate;

@Entity
public class Congregacao implements BaseEntity, Serializable, Comparable<Congregacao> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4851039412946099152L;

	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long idCon;

	@Column
	private String nome;

	@Column
	private String cidade;
	
	@Column
	private String bairro;

	@Column
	private String site;

	@Column
	@Email
	private String email;

	@Column
	@Temporal(TemporalType.DATE)
	@Past
	private Date fundacao;

	@Column
	private String lema;

	//
	// private Endereco endereco;

	@OneToMany(fetch=FetchType.EAGER, mappedBy="congregacao")
	@JoinColumn(nullable=true) // zero ou muitos
	private List<CongregacaoPastor> pastores;

	@Column
	private String historico;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date cadastro;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date exclusao;
	
	@PrePersist
	void preInsert() {
		if(this.cadastro == null) {
			this.cadastro = CustomDate.getCurrentDate();
		} else {
			this.alteracao = CustomDate.getCurrentDate();
		}
	}
	
	public Long getIdCon() {
		return idCon;
	}

	public void setIdCon(Long id) {
		this.idCon = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFundacao() {
		return fundacao;
	}

	public void setFundacao(Date fundacao) {
		this.fundacao = fundacao;
	}

	public String getLema() {
		return lema;
	}

	public void setLema(String lema) {
		this.lema = lema;
	}

	public List<CongregacaoPastor> getPastores() {
		return pastores;
	}

	public void setPastores(List<CongregacaoPastor> pastores) {
		this.pastores = pastores;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public Date getExclusao() {
		return exclusao;
	}

	public void setExclusao(Date exclusao) {
		this.exclusao = exclusao;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setAlteracao(Date alteracao) {
		this.alteracao = alteracao;
	}

	public Date getAlteracao() {
		return alteracao;
	}

	@Override
	public Long getId() {
		return getIdCon();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alteracao == null) ? 0 : alteracao.hashCode());
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result
				+ ((cadastro == null) ? 0 : cadastro.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((exclusao == null) ? 0 : exclusao.hashCode());
		result = prime * result
				+ ((fundacao == null) ? 0 : fundacao.hashCode());
		result = prime * result
				+ ((historico == null) ? 0 : historico.hashCode());
		result = prime * result + ((idCon == null) ? 0 : idCon.hashCode());
		result = prime * result + ((lema == null) ? 0 : lema.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
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
		Congregacao other = (Congregacao) obj;
		if (alteracao == null) {
			if (other.alteracao != null)
				return false;
		} else if (!alteracao.equals(other.alteracao))
			return false;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cadastro == null) {
			if (other.cadastro != null)
				return false;
		} else if (!cadastro.equals(other.cadastro))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (exclusao == null) {
			if (other.exclusao != null)
				return false;
		} else if (!exclusao.equals(other.exclusao))
			return false;
		if (fundacao == null) {
			if (other.fundacao != null)
				return false;
		} else if (!fundacao.equals(other.fundacao))
			return false;
		if (historico == null) {
			if (other.historico != null)
				return false;
		} else if (!historico.equals(other.historico))
			return false;
		if (idCon == null) {
			if (other.idCon != null)
				return false;
		} else if (!idCon.equals(other.idCon))
			return false;
		if (lema == null) {
			if (other.lema != null)
				return false;
		} else if (!lema.equals(other.lema))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		return true;
	}

	@Override
	public int compareTo(Congregacao o) {
		
		final int IGUAL = 0;
		final int ANTES = -1;
		final int DEPOIS = 1;
	    
	    if (o == null) {
	    	return ANTES;
	    }
	    
	    //o mesmo objeto sendo comparado
		if (this == o) {
			return IGUAL;
		}
		
		long difId = (this.idCon!=null?this.idCon:0) - (o.getIdCon()!=null?o.getIdCon():0);
		if (difId != 0) {
			return (difId > IGUAL ? DEPOIS : ANTES);
		}
		
		if (this.nome == null) {
			return ANTES;
		}
		
		return this.nome.compareToIgnoreCase(o.getNome());
	}
	
	
	
}
