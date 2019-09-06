package br.org.vilicum.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.UsuarioBC;
import br.org.vilicum.domain.Usuario;

@ViewController
@NextView("./usuario_edit.jsf")
@PreviousView("./usuario_list.jsf")
public class UsuarioListMB extends AbstractListPageBean<Usuario, String> {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioBC usuarioBC;
	
	@Override
	protected List<Usuario> handleResultList() {
		return this.usuarioBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<String> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			String id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				usuarioBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}