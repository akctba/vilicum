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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

import br.org.vilicum.util.BaseEntity;

@Entity
public class Pastor implements BaseEntity, Serializable, Comparable<Pastor> {

	private static final long serialVersionUID = -3829420320395552261L;

	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long idPastor;
	
	@Column
	private String nome;
	
	@Column
	private int anoFormacao;
	
	@Column
	private String email;
	
	@Column
	@Temporal(TemporalType.DATE) @Past
	private Date nascimento;
	
	@Column
	private String nomeEsposa;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="pastor")
	@JoinColumn(nullable=true)
	private List<CongregacaoPastor> congregacoes; // zero ou muitos
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date cadastro;
	
	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date exclusao;
	
	public Long getId() {
		return idPastor;
	}

	public void setId(Long id) {
		this.idPastor = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoFormacao() {
		return anoFormacao;
	}

	public void setAnoFormacao(int anoFormacao) {
		this.anoFormacao = anoFormacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getNomeEsposa() {
		return nomeEsposa;
	}

	public void setNomeEsposa(String nomeEsposa) {
		this.nomeEsposa = nomeEsposa;
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

	public Long getIdPastor() {
		return idPastor;
	}

	public void setIdPastor(Long idPastor) {
		this.idPastor = idPastor;
	}

	public List<CongregacaoPastor> getCongregacoes() {
		return congregacoes;
	}

	public void setCongregacoes(List<CongregacaoPastor> congregacoes) {
		this.congregacoes = congregacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anoFormacao;
		result = prime * result
				+ ((cadastro == null) ? 0 : cadastro.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((exclusao == null) ? 0 : exclusao.hashCode());
		result = prime * result
				+ ((idPastor == null) ? 0 : idPastor.hashCode());
		result = prime * result
				+ ((nascimento == null) ? 0 : nascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((nomeEsposa == null) ? 0 : nomeEsposa.hashCode());
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
		Pastor other = (Pastor) obj;
		if (anoFormacao != other.anoFormacao)
			return false;
		if (cadastro == null) {
			if (other.cadastro != null)
				return false;
		} else if (!cadastro.equals(other.cadastro))
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
		if (idPastor == null) {
			if (other.idPastor != null)
				return false;
		} else if (!idPastor.equals(other.idPastor))
			return false;
		if (nascimento == null) {
			if (other.nascimento != null)
				return false;
		} else if (!nascimento.equals(other.nascimento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeEsposa == null) {
			if (other.nomeEsposa != null)
				return false;
		} else if (!nomeEsposa.equals(other.nomeEsposa))
			return false;
		return true;
	}

	@Override
	public int compareTo(Pastor o) {
		if (this.nome == null) {
			return -1;
		}
		return this.nome.compareTo(o.getNome());
	}

}