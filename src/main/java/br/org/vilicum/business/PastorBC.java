package br.org.vilicum.business;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.vilicum.domain.Pastor;
import br.org.vilicum.persistence.PastorDAO;

@BusinessController
public class PastorBC extends DelegateCrud<Pastor, Long, PastorDAO> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2022513711918421912L;
	
	@Inject
	private PastorDAO dao;
	
	@Override
	public void delete(Long id) {
		//super.delete(id);
	}

	@Override
	public void delete(List<Long> ids) {
		//super.delete(ids);
	}
	
	public List<Pastor> pastoresCongregacao(long id) {
		return dao.findByCongregacao(id);
	}
	
}
