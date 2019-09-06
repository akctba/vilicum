package br.org.vilicum.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.DepartamentoBC;
import br.org.vilicum.domain.Departamento;

@ViewController
@NextView("./departamento_edit.jsf")
@PreviousView("./departamento_list.jsf")
public class DepartamentoListMB extends AbstractListPageBean<Departamento, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DepartamentoBC departamentoBC;
	
	@Override
	protected List<Departamento> handleResultList() {
		return this.departamentoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				departamentoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}