package br.org.vilicum.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.CongregacaoBC;
import br.org.vilicum.domain.Congregacao;

@ViewController
@PreviousView("./congregacao_list.jsf")
public class CongregacaoEditMB extends AbstractEditPageBean<Congregacao, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private CongregacaoBC congregacaoBC;
	
	@Override
	@Transactional
	public String delete() {
		this.congregacaoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	@RequiredRole("Administrador")
	public String insert() {
		this.congregacaoBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	@RequiredRole("Administrador")
	public String update() {
		this.congregacaoBC.update(getBean());
		return getPreviousView();
	}
	
	protected void handleLoad() {
		setBean(this.congregacaoBC.load(getId()));
	}

	@Override
	protected Congregacao handleLoad(Long id) {
		return this.congregacaoBC.load(getId());
	}

}