package br.org.vilicum.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.CongregacaoPastorBC;
import br.org.vilicum.domain.CongregacaoPastor;

@ViewController
@NextView("./congregacaoPastor_edit.jsf")
@PreviousView("./congregacaoPastor_list.jsf")
public class CongregacaoPastorListMB extends AbstractListPageBean<CongregacaoPastor, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private CongregacaoPastorBC congregacaoPastorBC;
	
	@Override
	protected List<CongregacaoPastor> handleResultList() {
		return this.congregacaoPastorBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				congregacaoPastorBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}