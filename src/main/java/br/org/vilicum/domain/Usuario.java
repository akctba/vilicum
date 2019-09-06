package br.org.vilicum.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario implements br.gov.frameworkdemoiselle.security.User, Serializable, java.security.Principal {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2323465744818274922L;

	@Id
	private String id;
	
	@Column
	private String password;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@ManyToOne
	@JoinColumn(name="idCon")
	private Congregacao congregacao;
	
	@ManyToMany
	@JoinTable(name="usuario_perfil", joinColumns=@JoinColumn(name="usu_id"), inverseJoinColumns=@JoinColumn(name="perfil_id"))
	private List<Perfil> perfis;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimoAcesso;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date inclusao;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date exclusao;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date alteracao;
	
	@Column
	private boolean trocarSenha;
	
	public boolean isTrocarSenha() {
		return trocarSenha;
	}

	public void setTrocarSenha(boolean trocarSenha) {
		this.trocarSenha = trocarSenha;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public Object getAttribute(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(Object key, Object value) {
		// TODO Auto-generated method stub
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Congregacao getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public Date getInclusao() {
		return inclusao;
	}

	public void setInclusao(Date inclusao) {
		this.inclusao = inclusao;
	}

	public Date getExclusao() {
		return exclusao;
	}

	public void setExclusao(Date exclusao) {
		this.exclusao = exclusao;
	}

	public Date getAlteracao() {
		return alteracao;
	}

	public void setAlteracao(Date alteracao) {
		this.alteracao = alteracao;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alteracao == null) ? 0 : alteracao.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((exclusao == null) ? 0 : exclusao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((inclusao == null) ? 0 : inclusao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((ultimoAcesso == null) ? 0 : ultimoAcesso.hashCode());
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
		Usuario other = (Usuario) obj;
		if (alteracao == null) {
			if (other.alteracao != null)
				return false;
		} else if (!alteracao.equals(other.alteracao))
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inclusao == null) {
			if (other.inclusao != null)
				return false;
		} else if (!inclusao.equals(other.inclusao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (ultimoAcesso == null) {
			if (other.ultimoAcesso != null)
				return false;
		} else if (!ultimoAcesso.equals(other.ultimoAcesso))
			return false;
		return true;
	}

	@Override
	public String getName() {
		return this.getId() + " - " + this.getNome();
	}
	
	public String toString() {
		return "Usuario " + this.getId() + " - " + this.getNome();
	}
	
}
