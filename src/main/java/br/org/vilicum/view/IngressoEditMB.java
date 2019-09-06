package br.org.vilicum.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.IngressoBC;
import br.org.vilicum.domain.Ingresso;

@ViewController
@PreviousView("./ingresso_list.jsf")
public class IngressoEditMB extends AbstractEditPageBean<Ingresso, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private IngressoBC ingressoBC;
	
	@Override
	@Transactional
	public String delete() {
		this.ingressoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.ingressoBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.ingressoBC.update(getBean());
		return getPreviousView();
	}
	
	protected void handleLoad() {
		setBean(this.ingressoBC.load(getId()));
	}

	@Override
	protected Ingresso handleLoad(Long id) {
		return this.ingressoBC.load(getId());
	}

}