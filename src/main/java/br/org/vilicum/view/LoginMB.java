package br.org.vilicum.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;
import br.org.vilicum.security.Credenciais;

@ViewController
@NextView("./index.jsf")
public class LoginMB extends AbstractPageBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4020465901593720912L;
	
	private String usuario = new String();
	private String senha = new String();

	@Inject
	private Credenciais credentials;

	@Inject
	private SecurityContext securityContext;

	@Inject
	private MessageContext messageContext;

	public String doLogin() {
		
		try {
			
			if (this.usuario == null || this.usuario.equals("")) {
				messageContext.add("Necessario informar o usuário e senha.");
				return getNextView();
			}
			
			credentials.setUsername(this.usuario);
			credentials.setPassword(this.senha);
			securityContext.login();
			
//			Usuario usr = (Usuario)securityContext.getUser();
//			if (usr != null && usr.isTrocarSenha()) {
//				return "verPerfil.jsf?faces-redirect=true";
//			}
			
		} catch (Exception e) {
			messageContext.add("{login.invalido}", SeverityType.ERROR);
			//FacesContext.getCurrentInstance().addMessage("password", new FacesMessage("{login.invalido}"));
			//FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			//TODO esta mensagem não está sendo exibida!!!
			// AuthenticationException
			return "erro.jsf?faces-redirect=true&e=AB35D843479E";
		}
		
		return getNextView();
	}

	public void doLogout() {
		securityContext.logout();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
