package br.org.vilicum.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.RegistroPastoralBC;
import br.org.vilicum.domain.RegistroPastoral;

@ViewController
@NextView("./registroPastoral_edit.jsf")
@PreviousView("./registroPastoral_list.jsf")
public class RegistroPastoralListMB extends AbstractListPageBean<RegistroPastoral, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private RegistroPastoralBC registroPastoralBC;
	
	@Override
	protected List<RegistroPastoral> handleResultList() {
		return this.registroPastoralBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				registroPastoralBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}