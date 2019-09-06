package br.org.vilicum.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.CultoBC;
import br.org.vilicum.domain.Culto;

@ViewController
@NextView("./culto_cadastro.jsf")
@PreviousView("./culto_lista.jsf")
public class CultoListMB extends AbstractListPageBean<Culto, Long> {

	private static final long serialVersionUID = 3186789406864342585L;
	
	@Inject
	private CultoBC cultoBC;
	
	@Override
	protected List<Culto> handleResultList() {
		this.clear();
		
		List<Culto> lista = cultoBC.findAll();
		
		for(Culto c : lista) {
			//System.out.println(c.toString() + " " + c.getSantaceia().size());
			c.getSantaceia().size();
		}
		
		return lista;
	}
	
//	@Override
//	public List<Culto> getResultList() {
//		// TODO Auto-generated method stub
//		return super.getResultList();
//	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				cultoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}