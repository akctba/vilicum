package br.org.vilicum.domain.view;

import static br.org.vilicum.util.CustomDate.getCurrentDate;
import static br.org.vilicum.util.CustomDate.getNumberDays;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.org.vilicum.domain.Genero;

@Entity
@Table(name="ultimaparticipacao")
public class UltimaParticipacao {
	
	@Id
	private Long idMembro;
	
	@Column (updatable=false)
	private Long idCon;
	
	@Column
	private String nome;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date nascimento;
	
	@Enumerated(EnumType.ORDINAL)
	private Genero sexo;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date ultima;

	public Long getIdMembro() {
		return idMembro;
	}

	public void setIdMembro(Long idMembro) {
		this.idMembro = idMembro;
	}

	public Long getIdCon() {
		return idCon;
	}

	public void setIdCon(Long idCon) {
		this.idCon = idCon;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Date getUltima() {
		return ultima;
	}

	public void setUltima(Date ultima) {
		this.ultima = ultima;
	}
	
	public Integer getDiasAfastamento() {
		if (this.ultima == null) {
			return 9999999; 
		}
		
		int numberDays = getNumberDays(this.ultima, getCurrentDate());
		
		if (numberDays < 0) {
			numberDays = 0;
		}
		
		return numberDays;
	}
	
}
