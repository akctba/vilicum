package br.org.vilicum.business;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.domain.Perfil;
import br.org.vilicum.persistence.PerfilDAO;

@BusinessController
public class PerfilBC extends DelegateCrud<Perfil, Long, PerfilDAO> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2653329668589916239L;
	
	@Inject
	private Logger logger;
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			insert(new Perfil("Administrador"));
			insert(new Perfil("Secretaria"));
			insert(new Perfil("Tesouraria"));
			insert(new Perfil("Diretoria"));
			insert(new Perfil("Pastor"));
		}
		logger.info("Lista de perfis carregadas");
	}
	
}
