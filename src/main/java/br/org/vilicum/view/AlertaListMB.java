package br.org.vilicum.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.AlertaBC;
import br.org.vilicum.domain.Alerta;

@ViewController
@NextView("./alerta_edit.jsf")
@PreviousView("./alerta_list.jsf")
public class AlertaListMB extends AbstractListPageBean<Alerta, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AlertaBC alertaBC;
	
	@Override
	protected List<Alerta> handleResultList() {
		return this.alertaBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				alertaBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}