package br.org.vilicum.business;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.persistence.CongregacaoDAO;
import br.org.vilicum.util.CustomDate;

@BusinessController
public class CongregacaoBC extends DelegateCrud<Congregacao, Long, CongregacaoDAO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2604851160297099320L;
	
	@Inject
	CongregacaoDAO dao;
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			Congregacao c = new Congregacao();
			c.setBairro("Hauer");
			c.setCadastro(CustomDate.getCurrentDate());
			c.setCidade("Curitiba");
			c.setEmail("diretoria@emcristo.org.br");
			c.setFundacao(CustomDate.parseDate("15/09/1963"));
			c.setHistorico("A congr...");
			c.setLema("Cristo para todos");
			c.setNome("São João");
			c.setSite("http://emcristo.org.br");
			insert(c);
		}
		
	}
	
	public Congregacao findById(Long id) {
		return dao.load(id);
	}
	
	public List<Congregacao> ativas() {
		return dao.ativas();
	}
}
