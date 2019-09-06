package br.org.vilicum.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.frameworkdemoiselle.validation.annotation.Cep;
import br.org.vilicum.util.BaseEntity;
import br.org.vilicum.util.CustomDate;

@Entity
public class Familia implements BaseEntity, Serializable {

	private static final long serialVersionUID = 4172741985664411891L;

	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long idFam;
	
	@Column(unique=true)
	private String nome;
	
	@OneToMany(mappedBy="familia")
	private List<Membro> membros;
	
	@Column
	private String rua;
	
	@Column
	private String nro;
	
	@Column
	private String complemento;
	
	@Column
	private String bairro;
	
	@Cep
	private String cep;
	
	@Column
	private String cidade;
	
	@Enumerated(EnumType.STRING)
	private Estados estado;
	
	@Column
	private String foneFixo;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date cadastro;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date exclusao;
	
	@ManyToOne
    @JoinColumn(name = "idCon")
	private Congregacao congregacao;
	
	@Column
	private String latitude;
	
	@Column
	private String longitude;
	
	@PrePersist
	public void preInsert() {
		if(this.cadastro == null) {
			this.cadastro = CustomDate.getCurrentDate();
		} else {
			this.alteracao = CustomDate.getCurrentDate();
		}
	}

	public Long getIdFam() {
		return idFam;
	}

	public void setIdFam(Long idFam) {
		this.idFam = idFam;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNro() {
		return nro;
	}

	public void setNro(String nro) {
		this.nro = nro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public String getFoneFixo() {
		return foneFixo;
	}

	public void setFoneFixo(String foneFixo) {
		this.foneFixo = foneFixo;
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

	public Date getExclusao() {
		return exclusao;
	}

	public void setExclusao(Date exclusao) {
		this.exclusao = exclusao;
	}

	public void setMembros(List<Membro> membros) {
		this.membros = membros;
	}

	public List<Membro> getMembros() {
		return membros;
	}
	
	public List<Membro> getAtivos() {
		List<Membro> ativos = new ArrayList<Membro>();
		if (membros!=null)
		for (Membro m : membros) {
			if (m.isAtivo() && !m.isExcluir())
				ativos.add(m);
		}
		return ativos;
	}
	
	public List<Membro> getNaoExcluidos() {
		List<Membro> ativos = new ArrayList<Membro>();
		if (membros!=null)
		for (Membro m : membros) {
			if (!m.isExcluir())
				ativos.add(m);
		}
		return ativos;
	}

	@Override
	public Long getId() {
		return this.idFam;
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
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result
				+ ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((exclusao == null) ? 0 : exclusao.hashCode());
		result = prime * result
				+ ((foneFixo == null) ? 0 : foneFixo.hashCode());
		result = prime * result + ((idFam == null) ? 0 : idFam.hashCode());
		//result = prime * result + ((membros == null) ? 0 : membros.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nro == null) ? 0 : nro.hashCode());
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
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
		Familia other = (Familia) obj;
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
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (estado != other.estado)
			return false;
		if (exclusao == null) {
			if (other.exclusao != null)
				return false;
		} else if (!exclusao.equals(other.exclusao))
			return false;
		if (foneFixo == null) {
			if (other.foneFixo != null)
				return false;
		} else if (!foneFixo.equals(other.foneFixo))
			return false;
		if (idFam == null) {
			if (other.idFam != null)
				return false;
		} else if (!idFam.equals(other.idFam))
			return false;
//		if (membros == null) {
//			if (other.membros != null)
//				return false;
//		} else if (!membros.equals(other.membros))
//			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nro == null) {
			if (other.nro != null)
				return false;
		} else if (!nro.equals(other.nro))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		return true;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}

	public Congregacao getCongregacao() {
		return congregacao;
	}
	
	public String getEndereco() {
		String end = this.rua + ", " + this.nro;
		if (this.complemento != null) {
			end += " " + this.complemento;
		}
		return end;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
