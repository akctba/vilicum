package br.org.vilicum.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.PastorBC;
import br.org.vilicum.domain.Pastor;

@ViewController
@NextView("./pastor_edit.jsf")
@PreviousView("./pastor_list.jsf")
public class PastorListMB extends AbstractListPageBean<Pastor, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PastorBC pastorBC;
	
	@Override
	protected List<Pastor> handleResultList() {
		return this.pastorBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				pastorBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}