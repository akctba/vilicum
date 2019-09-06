package br.org.vilicum.view;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.CongregacaoBC;
import br.org.vilicum.business.CongregacaoPastorBC;
import br.org.vilicum.business.PastorBC;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.CongregacaoPastor;
import br.org.vilicum.domain.Pastor;

@ViewController
@PreviousView("./congregacaoPastor_list.jsf")
public class CongregacaoPastorEditMB extends AbstractEditPageBean<CongregacaoPastor, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5995179701632267018L;

	@Inject
	private CongregacaoPastorBC congregacaoPastorBC;
	
	@Inject
	private CongregacaoBC congBC;
	
	@Inject
	private PastorBC pastorBC;
	
	@Override
	@Transactional
	public String delete() {
		this.congregacaoPastorBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	@RequiredRole("Administrador")
	public String insert() {
		this.congregacaoPastorBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	@RequiredRole("Administrador")
	public String update() {
		this.congregacaoPastorBC.update(getBean());
		return getPreviousView();
	}
	
	protected void handleLoad() {
		setBean(this.congregacaoPastorBC.load(getId()));
	}

	@Override
	protected CongregacaoPastor handleLoad(Long id) {
		return this.congregacaoPastorBC.load(getId());
	}
	

	public List<Congregacao> getCongregacoes() {
		return congBC.ativas();
	}
	
	public List<Pastor> getPastores() {
		return pastorBC.findAll();
	}

}