package br.org.vilicum.security;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.org.vilicum.domain.Usuario;

@SessionScoped
@Named
public class Credenciais implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -977951844713691134L;
	
	private String username;
	private String password;
	
	private Usuario usuario;
	
	private Date ultimoAcesso;
	
	public void clear() {
        username = null;
        password = null;
        usuario = null;
    }
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String nome) {
		this.username = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String senha) {
		this.password = senha;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}
	
//	public void login() {
//		//System.out.println("Vai.........");
//		context.login();
//	}
	
}
