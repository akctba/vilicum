package br.org.vilicum.view;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.UsuarioBC;
import br.org.vilicum.domain.Usuario;
import br.org.vilicum.security.Cripto;
import br.org.vilicum.util.Validator;

import java.io.Serializable;

import javax.inject.Inject;

import org.slf4j.Logger;

@ViewController
public class AlterarSenhaMB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9101770811739898347L;
	
	@Inject
	private Logger logger;
	
	private String atual = "";
	
	private String nova = "";
	
	private String confirmacao = "";
	
	@Inject
	private UsuarioBC usuarioBC;
	
	@Inject
	private SecurityContext securityContext;
	
	@Inject
	private MessageContext messageContext;
	
	@Transactional
	public String update() {
		
		try {
			// carrega o usuario
			Usuario usrLog = (Usuario) securityContext.getUser();
			
			if (validate(usrLog)) {
				Usuario user = usuarioBC.load(usrLog.getId());

				String nSenha = Cripto.digest(this.nova);
				user.setPassword(nSenha);
				user.setTrocarSenha(false);
				
				this.usuarioBC.update(user);
				
				usrLog.setTrocarSenha(false);
				
				messageContext.add("Senha alterada com sucesso!");
			} else {
				atual = "";
				nova = "";
				confirmacao = "";
			}
			
		} catch (Exception e) {
			logger.warn("Erro ao alterar senha: " + e.getMessage());
			messageContext.add(e.getMessage());
			atual = "";
			nova = "";
			confirmacao = "";
		}
		
		return "";
		
	}
	
	private boolean validate(Usuario user) {
		boolean valid = true;
		
		if (Validator.isEmpty(atual)) {
			messageContext.add("Necessário preencher a senha atual.");
			valid = false;
		}

		if (Validator.isEmpty(nova)) {
			messageContext.add("Necessário preencher a senha nova.");
			valid = false;
		}

		if (Validator.isEmpty(confirmacao)) {
			messageContext.add("Necessário preencher a confirmação de senha.");
			valid = false;
		}
		
		if (nova.equals(atual)) {
			messageContext.add("Nova senha deve ser diferente da atual.");
			valid = false;
		}
		
		if (!nova.equals(confirmacao)) {
			messageContext.add("Nova senha e confirmação não conferem.");
			valid = false;
		}
		
		// valida senha atual
		String digest = Cripto.digest(atual);
		if (!digest.equals(user.getPassword())) {
			messageContext.add("Senha atual inválida");
			valid = false;
		}
		
		return valid;
	}

	public String getAtual() {
		return atual;
	}

	public void setAtual(String atual) {
		this.atual = atual;
	}

	public String getNova() {
		return nova;
	}

	public void setNova(String nova) {
		this.nova = nova;
	}

	public String getConfirmacao() {
		return confirmacao;
	}

	public void setConfirmacao(String confirmacao) {
		this.confirmacao = confirmacao;
	}

}
