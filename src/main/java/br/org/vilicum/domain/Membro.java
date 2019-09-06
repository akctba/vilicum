package br.org.vilicum.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
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

import br.org.vilicum.security.DeEncrypter;
import br.org.vilicum.util.BaseEntity;
import br.org.vilicum.util.CustomDate;
import br.org.vilicum.util.Validator;

@Entity
public class Membro implements BaseEntity, Serializable, Comparable<Membro> {

	private static final long serialVersionUID = -7108826956450320009L;

	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long idMembro;
	
	@ManyToOne
	@JoinColumn(name="idFam")
	private Familia familia;
	
	@Column
	private String nome;
	
	@ManyToOne  //unidirecional
	@JoinColumn(nullable=false)
	private Ingresso formaIngresso;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date nascimento;
	
	@Enumerated(EnumType.ORDINAL)
	private Genero sexo;
	
	@Column
	private String localNascimento;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataBatismo;
	
	@Column
	private String localBatismo;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataCasamento;
	
	@Column
	private String localCasamento;
	
	@Enumerated(EnumType.ORDINAL)
	private EstadoCivil estadoCivil;
	
	@Column
	private String profissao;
	
	@Column
	private boolean comungante;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date comungantedesde;
	
	@Column
	private boolean responsavelFamilia;
	
	@Column
	private String celular;
	
	@Column
	private String email;
	
	@Column
	private String observacoes;
	
	@Column
	private String motivoInativo;
	
	@Column
	private boolean excluir;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date recadastro;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataEntrada;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataSaida;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date cadastro;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;
	
	@ManyToOne
    @JoinColumn(name = "idCon")
	private Congregacao congregacao;
	
	@OneToMany(mappedBy="membro")
	private List<RegistroPastoral> registros;
	
	@PrePersist
	void preInsert() {
		if(this.cadastro == null) {
			this.cadastro = CustomDate.getCurrentDate();
		} else {
			this.alteracao = CustomDate.getCurrentDate();
		}
	}

	public Long getIdMembro() {
		return idMembro;
	}

	public void setIdMembro(Long idMembro) {
		this.idMembro = idMembro;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Ingresso getFormaIngresso() {
		return formaIngresso;
	}

	public void setFormaIngresso(Ingresso formaIngresso) {
		this.formaIngresso = formaIngresso;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Genero getSexo() {
		return sexo;
	}

	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}

	public String getLocalNascimento() {
		return localNascimento;
	}

	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}

	public Date getDataBatismo() {
		return dataBatismo;
	}

	public void setDataBatismo(Date dataBatismo) {
		this.dataBatismo = dataBatismo;
	}

	public String getLocalBatismo() {
		return localBatismo;
	}

	public void setLocalBatismo(String localBatismo) {
		this.localBatismo = localBatismo;
	}

	public Date getDataCasamento() {
		return dataCasamento;
	}

	public void setDataCasamento(Date dataCasamento) {
		this.dataCasamento = dataCasamento;
	}

	public String getLocalCasamento() {
		return localCasamento;
	}

	public void setLocalCasamento(String localCasamento) {
		this.localCasamento = localCasamento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public boolean isAtivo() {
		return this.dataSaida==null;
	}

//	public void setAtivo(boolean ativo) {
//		this.ativo = ativo;
//	}

	public boolean isComungante() {
		return comungante;
	}

	public void setComungante(boolean comungante) {
		this.comungante = comungante;
	}

	public boolean isResponsavelFamilia() {
		return responsavelFamilia;
	}

	public void setResponsavelFamilia(boolean responsavelFamilia) {
		this.responsavelFamilia = responsavelFamilia;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getMotivoInativo() {
		return motivoInativo;
	}

	public void setMotivoInativo(String motivoInativo) {
		this.motivoInativo = motivoInativo;
	}

	public boolean isExcluir() {
		return excluir;
	}

	public void setExcluir(boolean excluir) {
		this.excluir = excluir;
	}

	public Date getRecadastro() {
		return recadastro;
	}

	public void setRecadastro(Date recadastro) {
		this.recadastro = recadastro;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
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

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public Familia getFamilia() {
		return familia;
	}

	@Override
	public Long getId() {
		return this.idMembro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alteracao == null) ? 0 : alteracao.hashCode());
		//result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result
				+ ((cadastro == null) ? 0 : cadastro.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + (comungante ? 1231 : 1237);
		result = prime * result
				+ ((dataBatismo == null) ? 0 : dataBatismo.hashCode());
		result = prime * result
				+ ((dataCasamento == null) ? 0 : dataCasamento.hashCode());
		result = prime * result
				+ ((dataEntrada == null) ? 0 : dataEntrada.hashCode());
		result = prime * result
				+ ((dataSaida == null) ? 0 : dataSaida.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result + (excluir ? 1231 : 1237);
		result = prime * result + ((familia == null) ? 0 : familia.hashCode());
		result = prime * result
				+ ((formaIngresso == null) ? 0 : formaIngresso.hashCode());
		result = prime * result
				+ ((idMembro == null) ? 0 : idMembro.hashCode());
		result = prime * result
				+ ((localBatismo == null) ? 0 : localBatismo.hashCode());
		result = prime * result
				+ ((localCasamento == null) ? 0 : localCasamento.hashCode());
		result = prime * result
				+ ((localNascimento == null) ? 0 : localNascimento.hashCode());
		result = prime * result
				+ ((motivoInativo == null) ? 0 : motivoInativo.hashCode());
		result = prime * result
				+ ((nascimento == null) ? 0 : nascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((observacoes == null) ? 0 : observacoes.hashCode());
		result = prime * result
				+ ((profissao == null) ? 0 : profissao.hashCode());
		result = prime * result
				+ ((recadastro == null) ? 0 : recadastro.hashCode());
		result = prime * result + (responsavelFamilia ? 1231 : 1237);
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Membro other = (Membro) obj;
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
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (comungante != other.comungante)
			return false;
		if (dataBatismo == null) {
			if (other.dataBatismo != null)
				return false;
		} else if (!dataBatismo.equals(other.dataBatismo))
			return false;
		if (dataCasamento == null) {
			if (other.dataCasamento != null)
				return false;
		} else if (!dataCasamento.equals(other.dataCasamento))
			return false;
		if (dataEntrada == null) {
			if (other.dataEntrada != null)
				return false;
		} else if (!dataEntrada.equals(other.dataEntrada))
			return false;
		if (dataSaida == null) {
			if (other.dataSaida != null)
				return false;
		} else if (!dataSaida.equals(other.dataSaida))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (estadoCivil == null) {
			if (other.estadoCivil != null)
				return false;
		} else if (!estadoCivil.equals(other.estadoCivil))
			return false;
		if (excluir != other.excluir)
			return false;
		if (familia == null) {
			if (other.familia != null)
				return false;
		} else if (!familia.equals(other.familia))
			return false;
		if (formaIngresso == null) {
			if (other.formaIngresso != null)
				return false;
		} else if (!formaIngresso.equals(other.formaIngresso))
			return false;
		if (idMembro == null) {
			if (other.idMembro != null)
				return false;
		} else if (!idMembro.equals(other.idMembro))
			return false;
		if (localBatismo == null) {
			if (other.localBatismo != null)
				return false;
		} else if (!localBatismo.equals(other.localBatismo))
			return false;
		if (localCasamento == null) {
			if (other.localCasamento != null)
				return false;
		} else if (!localCasamento.equals(other.localCasamento))
			return false;
		if (localNascimento == null) {
			if (other.localNascimento != null)
				return false;
		} else if (!localNascimento.equals(other.localNascimento))
			return false;
		if (motivoInativo == null) {
			if (other.motivoInativo != null)
				return false;
		} else if (!motivoInativo.equals(other.motivoInativo))
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
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		if (profissao == null) {
			if (other.profissao != null)
				return false;
		} else if (!profissao.equals(other.profissao))
			return false;
		if (recadastro == null) {
			if (other.recadastro != null)
				return false;
		} else if (!recadastro.equals(other.recadastro))
			return false;
		if (responsavelFamilia != other.responsavelFamilia)
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}

	public Congregacao getCongregacao() {
		return congregacao;
	}
	
	public Date getComungantedesde() {
		return comungantedesde;
	}

	public void setComungantedesde(Date comungantedesde) {
		this.comungantedesde = comungantedesde;
	}
	
	public Integer getIdade() {
		if (this.nascimento != null) {
			return CustomDate.getIdade(this.nascimento);
		} 
		return null;
	}

	@Override
	public String toString() {
		return "Membro [idMembro=" + idMembro + ", nome=" + nome + "]";
	}
	
	public String getNomeSemAcento() {
		return Validator.removeAcentos(this.nome);
	}

	@Override
	public int compareTo(Membro o) {
		if (this.nome == null) {
			return -1;
		}
		return this.nome.compareTo(o.getNome());
	}

	public int getMesAniver() {
		return CustomDate.getMonth(this.nascimento);
	}
	
	public int getDiaAniver() {
		return CustomDate.getDay(this.nascimento);
	}

	public List<RegistroPastoral> getRegistros() {
		return registros;
	}

	public void setRegistros(List<RegistroPastoral> registros) {
		this.registros = registros;
	}
	
	/**
	 * Nota do cadastro do membro
	 * @return
	 */
	public int getPercCadastro() {
		float nota = 0;
		int i = 0;
		
		nota += (this.familia!=null?1:0); i++;
		nota += (this.estadoCivil!=null?1:0); i++;
		nota += (this.formaIngresso!=null?1:0); i++;
		nota += (this.estadoCivil!=null?1:0); i++;
		nota += (this.sexo!=null?1:0); i++;
		nota += (this.nascimento!=null?1:0); i++;
		nota += (this.dataBatismo!=null?1:0); i++;
		nota += (this.dataEntrada!=null?2:0); i++;i++;
		nota += (this.comungantedesde!=null?2:0); i++;i++;
		nota += (Validator.isEmpty(this.email)?0:1); i++;
		if (this.recadastro != null) {
			int dr = CustomDate.getNumberDays(recadastro, CustomDate.getCurrentDate());
			nota += (dr<365?1:0); i++;
		}
		if (this.estadoCivil == EstadoCivil.CASADO) {
			nota += (this.dataCasamento!=null?1:0); i++;
		}
		
		nota += (Validator.isEmpty(this.nome)?0:1); i++;
		nota += (Validator.isEmpty(this.celular)?0:1); i++;
		nota += (Validator.isEmpty(this.profissao)?0:1); i++;
		
		nota = ((nota/i)*100);
		
		return (int)nota;
	}
	
	public String getIdFoto() {
		String idFoto = "";
		try {
			idFoto = this.congregacao.getId()+";"+this.idMembro;
			idFoto = DeEncrypter.getInstance().encrypt(idFoto);
		} catch (Exception e) {
			// manda vazio
		}
		return idFoto;
	}
}
