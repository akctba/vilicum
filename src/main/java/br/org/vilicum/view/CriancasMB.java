package br.org.vilicum.view;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.org.vilicum.business.MembroBC;
import br.org.vilicum.domain.Membro;

@ViewController
public class CriancasMB implements Serializable {
	
	private static final long serialVersionUID = -1280514175045693011L;
	
	private List<Membro> criancasList;
	
	@Inject
	private MembroBC membroBC;
	
	@Inject 
    private SecurityContext context;
	
	public List<Membro> getCriancasList() {
		if (!context.isLoggedIn()) {
			return null;
		}
		
		if (criancasList == null) {
			criancasList = this.membroBC.findCriancas();
		}
		return criancasList;
	}
	
	public void setCriancasList(List<Membro> lista) {
		criancasList = lista;
	}
	
}