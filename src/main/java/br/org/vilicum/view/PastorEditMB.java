package br.org.vilicum.view;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.CongregacaoBC;
import br.org.vilicum.business.PastorBC;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Pastor;
import br.org.vilicum.util.CustomDate;

@ViewController
@PreviousView("./pastor_list.jsf")
public class PastorEditMB extends AbstractEditPageBean<Pastor, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PastorBC pastorBC;
	
	@Inject
	private CongregacaoBC congregacaoBC;
	
	@Override
	@Transactional
	@RequiredRole("Administrador")
	public String delete() {
		this.pastorBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	@RequiredRole("Administrador")
	public String insert() {
		Pastor bean = getBean();
		if (bean.getCadastro() == null) {
			bean.setCadastro(CustomDate.getCurrentDate());
		}
		this.pastorBC.insert(bean);
		return getPreviousView();
	}
	
	@Override
	@Transactional
	@RequiredRole("Administrador")
	public String update() {
		this.pastorBC.update(getBean());
		return getPreviousView();
	}
	
	protected void handleLoad() {
		setBean(this.pastorBC.load(getId()));
	}

	@Override
	protected Pastor handleLoad(Long id) {
		return this.pastorBC.load(getId());
	}
	
	public List<Congregacao> getCongregacoes() {
		return congregacaoBC.ativas();
	}

}