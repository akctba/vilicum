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

import br.org.vilicum.security.DeEncrypter;
import br.org.vilicum.util.BaseEntity;

@Entity
public class RegistroPastoral implements BaseEntity, Serializable {

	private static final long serialVersionUID = 4208077931809293579L;

	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long idReg;
	
	@ManyToOne
	@JoinColumn(name="idMembro")
	private Membro membro;
	
	@ManyToOne
	@JoinColumn(name="idPastor")
	private Usuario pastor;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtRegistro;
	
	@Column
	private String assunto;
	
	@Column(length=2500)
	private String registro;

	@Override
	public Long getId() {
		return idReg;
	}

	public Long getIdReg() {
		return idReg;
	}

	public void setIdReg(Long idReg) {
		this.idReg = idReg;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}

	public Usuario getPastor() {
		return pastor;
	}

	public void setPastor(Usuario pastor) {
		this.pastor = pastor;
	}

	public Date getDtRegistro() {
		return dtRegistro;
	}

	public void setDtRegistro(Date dtRegistro) {
		this.dtRegistro = dtRegistro;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}
	
	public String getRegistroDec() {
		return DeEncrypter.getInstance().decrypt(registro);
	}
	
}
