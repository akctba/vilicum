package br.org.vilicum.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.org.vilicum.util.BaseEntity;

@Entity
public class Alerta implements BaseEntity, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2382342417878335810L;

	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long idAlerta;
	
	@Column
	private String texto;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date cadastro;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date validade;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date execucao;
	
	@ManyToOne
	@JoinColumn(name="idUsr")
	private Usuario executor;
	
	@ManyToOne
	@JoinColumn(name="idCon")
	private Congregacao congregacao;
	
	public Alerta() {
		super();
	}
	
	public Alerta(String texto, Date cadastro, Date validade, 
			Congregacao congregacao, Date execucao, Usuario executor) {
		super();
		this.texto = texto;
		this.cadastro = cadastro;
		this.validade = validade;
		this.execucao = execucao;
		this.executor = executor;
		this.congregacao = congregacao;
	}
	
	public Long getIdAlerta() {
		return idAlerta;
	}

	public void setIdAlerta(Long idAlerta) {
		this.idAlerta = idAlerta;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public Date getExecucao() {
		return execucao;
	}

	public void setExecucao(Date execucao) {
		this.execucao = execucao;
	}

	public Usuario getExecutor() {
		return executor;
	}

	public void setExecutor(Usuario executor) {
		this.executor = executor;
	}

	@Override
	public Long getId() {
		return this.idAlerta;
	}

	public Congregacao getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}
	

}
