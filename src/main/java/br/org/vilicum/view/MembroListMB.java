package br.org.vilicum.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.report.Report;
import br.gov.frameworkdemoiselle.report.Type;
import br.gov.frameworkdemoiselle.report.annotation.Path;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Faces;
import br.gov.frameworkdemoiselle.util.FileRenderer;
import br.org.vilicum.business.MembroBC;
import br.org.vilicum.domain.Membro;

@ViewController
@NextView("./membro_edit.jsf")
@PreviousView("./membro_list.jsf")
public class MembroListMB extends AbstractListPageBean<Membro, Long> {

	private static final long serialVersionUID = 1397408962571951093L;
	
	private boolean mostrarTodos = false;
	
	@Inject
	private MembroBC membroBC;
	
	@Inject
	private SecurityContext securityContext;
	
	@Inject
    @Path("reports/Bookmarks.jrxml")
    private Report relatorio;
	
	@Inject
	private FileRenderer renderer;
	
	@Override
	protected List<Membro> handleResultList() {
		if (mostrarTodos) {
			return this.membroBC.findAll();
		}
		return this.membroBC.findAtivos();
	}
	
	public List<Membro> getAtivos() {
		return this.membroBC.findAtivos();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				membroBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}
	
	
	public String showReport() {

	    Map<String, Object> param = new HashMap<String, Object>();

	    try {
	        byte[] buffer = this.relatorio.export(getAtivos(), param, Type.PDF);

	        this.renderer.render(buffer, FileRenderer.ContentType.PDF, "relatorioMembros.pdf");

	    } catch (Exception e) {
	        Faces.addMessage(e);
	    }

	    return getPreviousView();

	}

	public boolean isMostrarTodos() {
		return mostrarTodos;
	}

	public void setMostrarTodos(boolean mostrarTodos) {
		this.mostrarTodos = mostrarTodos;
	}
	
//	public List<Integer> getMeses() {
//		List<Integer> lista = new ArrayList<Integer>();
//		for (int i=1; i<=12; i++)
//			lista.add(i);
//		return lista;
//	}
	
	public SelectItem[] getMesesOptions() {
		SelectItem[] options = new SelectItem[13];
		options[0] = new SelectItem("", "Selecione");
		for(int i = 1; i <=12 ; i++) {  
            options[i] = new SelectItem(i, i+"");  
        }
		return options;
	}

}