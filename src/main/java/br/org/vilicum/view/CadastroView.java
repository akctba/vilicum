package br.org.vilicum.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.org.vilicum.business.CultoBC;
import br.org.vilicum.business.FamiliaBC;
import br.org.vilicum.business.MembroBC;
import br.org.vilicum.pojo.Movimento;

@ViewController
public class CadastroView implements Serializable {
	
	private static final long serialVersionUID = -5602912813452951735L;

	@Inject
	private Logger logger;
	
	@Inject
	private CultoBC cultoBC;

	@Inject
	private MembroBC membroBC;
	
	@Inject
	private FamiliaBC familiaBC;
	
	@Inject
	private SecurityContext securityContext;
	
	private List<Movimento> analiseMembros;
	
	private List<Movimento> analiseFamilias;
	
	@PostConstruct
    public void init() {
		analiseMembros = membroBC.analise();
	}

	public List<Movimento> getAnaliseMembros() {
		return analiseMembros;
	}

	public void setAnaliseMembros(List<Movimento> analiseMembros) {
		this.analiseMembros = analiseMembros;
	}

	public List<Movimento> getAnaliseFamilias() {
		return analiseFamilias;
	}

	public void setAnaliseFamilias(List<Movimento> analiseFamilias) {
		this.analiseFamilias = analiseFamilias;
	}

}
