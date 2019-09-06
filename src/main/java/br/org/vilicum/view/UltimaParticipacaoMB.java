package br.org.vilicum.view;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.org.vilicum.business.UltimaParticipacaoBC;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Membro;
import br.org.vilicum.domain.Usuario;
import br.org.vilicum.domain.view.UltimaParticipacao;

@ViewController
public class UltimaParticipacaoMB extends AbstractListPageBean<UltimaParticipacao, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4297605978833837481L;

	@Inject
	UltimaParticipacaoBC bc;
	
	@Inject
	private SecurityContext securityContext;
	
	private List<UltimaParticipacao> lista;
	
	@Override
	protected List<UltimaParticipacao> handleResultList() {
		
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		List<UltimaParticipacao> ultimaParticipacao = bc.findAll(c);
		return ultimaParticipacao;
	}
	
	public List<UltimaParticipacao> getLista() {
		if (lista == null) {
			lista = handleResultList();
		}
		return lista;
	}
	
	public Date ultimaParticipacao(Membro m) {
		return bc.ultimaParticipacao(m);
	}
}
