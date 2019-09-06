package br.org.vilicum.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.FamiliaBC;
import br.org.vilicum.domain.Familia;

@ViewController
@NextView("./familia_edit.jsf")
@PreviousView("./familia_list.jsf")
public class FamiliaListMB extends AbstractListPageBean<Familia, Long> {

	private static final long serialVersionUID = 8738375311131980389L;
	
	@Inject
	private FamiliaBC familiaBC;
	
	@Override
	protected List<Familia> handleResultList() {
		return this.familiaBC.ativas();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				familiaBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}