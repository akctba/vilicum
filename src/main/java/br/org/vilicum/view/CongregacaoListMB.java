package br.org.vilicum.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.CongregacaoBC;
import br.org.vilicum.domain.Congregacao;

@ViewController
@NextView("./congregacao_edit.jsf")
@PreviousView("./congregacao_list.jsf")
public class CongregacaoListMB extends AbstractListPageBean<Congregacao, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private CongregacaoBC congregacaoBC;
	
	@Override
	protected List<Congregacao> handleResultList() {
		return this.congregacaoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				congregacaoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}