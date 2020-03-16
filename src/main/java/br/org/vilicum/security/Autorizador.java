package br.org.vilicum.security;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.security.Authorizer;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.org.vilicum.domain.Perfil;
import br.org.vilicum.domain.Usuario;

@SessionScoped
public class Autorizador implements Authorizer {
	
	@Inject
	private Logger logger;
	
	@Inject
	private SecurityContext context;

	/**
	 * 
	 */
	private static final long serialVersionUID = 7723101503874301218L;

	@Override
	public boolean hasRole(String role) throws Exception {
		
		boolean has = false;
		
		Usuario user = (Usuario)context.getUser();
		for (Perfil p : user.getPerfis()) {
			if ("Administrador".equals(p.getNome()) || p.getNome().equals(role)) {
				has = true;
				break;
			}
		}
		
		return has;
	}

	@Override
	public boolean hasPermission(String resource, String operation) throws Exception {
		logger.debug("Demoiselle perguntou sobre recurso %s operacao [%s]", resource, operation);
		return true;
	}

}
