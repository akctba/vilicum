package br.org.vilicum.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.DepartamentoBC;
import br.org.vilicum.domain.Departamento;

@ViewController
@PreviousView("./departamento_list.jsf")
public class DepartamentoEditMB extends AbstractEditPageBean<Departamento, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DepartamentoBC departamentoBC;
	
	@Override
	@Transactional
	public String delete() {
		this.departamentoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.departamentoBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.departamentoBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected Departamento handleLoad(Long id) {
		return this.departamentoBC.load(id);
	}

}