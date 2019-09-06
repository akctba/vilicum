package br.org.vilicum.business;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.domain.Ingresso;
import br.org.vilicum.persistence.IngressoDAO;

@BusinessController
public class IngressoBC extends DelegateCrud<Ingresso, Long, IngressoDAO> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -394633513571462739L;
	
	@Inject
	IngressoDAO dao;
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			insert(new Ingresso("Batismo"));
			insert(new Ingresso("Transferêcia"));
			insert(new Ingresso("Profissão de fé"));
		}
	}

	public List<Ingresso> ativos() {
		return dao.ativos();
	}	
}
