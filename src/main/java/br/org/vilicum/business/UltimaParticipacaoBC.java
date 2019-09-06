package br.org.vilicum.business;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Membro;
import br.org.vilicum.domain.Usuario;
import br.org.vilicum.domain.view.UltimaParticipacao;
import br.org.vilicum.persistence.UltimaParticipacaoDAO;

@BusinessController
public class UltimaParticipacaoBC extends DelegateCrud<UltimaParticipacao, Long, UltimaParticipacaoDAO> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2416626843556252114L;
	
	@Inject
	private SecurityContext securityContext;
	
	@Inject 
	private UltimaParticipacaoDAO dao;
	
	public UltimaParticipacao findById(Long id) {
		return dao.load(id);
	}

	@Override
	public void delete(Long id) {
		//super.delete(id);
		//nao permitir exclusao fisica
	}

	@Override
	public void delete(List<Long> ids) {
		//super.delete(ids);
		//nao permitir exclusao fisica
	}
	
	public List<UltimaParticipacao> findAll(Congregacao c) {
		return dao.findAll(c);
	}
	
	@Override
	public List<UltimaParticipacao> findAll() {
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		return dao.findAll(c);
	}

	
	
	@Override
	public UltimaParticipacao insert(UltimaParticipacao bean) {
		return null;
	}

	@Override
	public UltimaParticipacao update(UltimaParticipacao bean) {
		return null;
	}

	public Date ultimaParticipacao(Membro m) {
		return dao.ultimaParticipacao(m);
	}

}
