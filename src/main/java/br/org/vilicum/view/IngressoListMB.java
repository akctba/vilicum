package br.org.vilicum.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.IngressoBC;
import br.org.vilicum.domain.Ingresso;

@ViewController
@NextView("./ingresso_edit.jsf")
@PreviousView("./ingresso_list.jsf")
public class IngressoListMB extends AbstractListPageBean<Ingresso, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private IngressoBC ingressoBC;
	
	@Override
	protected List<Ingresso> handleResultList() {
		return this.ingressoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				ingressoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}