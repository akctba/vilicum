package br.org.vilicum.business;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.vilicum.domain.CongregacaoPastor;
import br.org.vilicum.persistence.CongregacaoPastorDAO;

@BusinessController
public class CongregacaoPastorBC extends DelegateCrud<CongregacaoPastor, Long, CongregacaoPastorDAO> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8820417453446236328L;

	@Inject
	private CongregacaoBC congBC;
	
	@Inject
	private PastorBC pastorBC;

	@Override
	public CongregacaoPastor insert(CongregacaoPastor bean) {
		// buscar novamente em banco todas as refentencias à outras classes, fazer merge do resto
		bean.setCongregacao(congBC.load(bean.getCongregacao().getId()));
		bean.setPastor(pastorBC.load(bean.getPastor().getId()));
		return super.insert(bean);
	}

	@Override
	public CongregacaoPastor update(CongregacaoPastor bean) {
		// buscar novamente em banco todas as refentencias à outras classes, fazer merge do resto
		CongregacaoPastor loaded = load(bean.getId());
		loaded.setCongregacao(congBC.load(bean.getCongregacao().getId()));
		loaded.setPastor(pastorBC.load(bean.getPastor().getId()));
		loaded.setEntrada(bean.getEntrada());
		loaded.setSaida(bean.getSaida());
		return super.update(loaded);
	}
}
